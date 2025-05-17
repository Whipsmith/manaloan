package kiwi.manaloan.presentation.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kiwi.manaloan.auth.entity.AuthState
import kiwi.manaloan.auth.provider.AuthProvider
import kiwi.manaloan.feature.navigation.FeatureNavGraph
import kiwi.manaloan.feature.navigation.MainNavItem
import kiwi.manaloan.feature_flag.FeatureFlag
import kiwi.manaloan.feature_flag.isFeatureEnabled
import kiwi.manaloan.presentation.app.model.AppState
import kiwi.manaloan.presentation.app.model.AppStateDataBuilder
import kiwi.manaloan.presentation.app.model.appStateData
import kiwi.manaloan.presentation.app.provider.GetDetailNavigationGraphs
import kiwi.manaloan.presentation.app.provider.GetFeatureFlagMap
import kiwi.manaloan.presentation.app.provider.GetMainNavItems
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@OptIn(ExperimentalCoroutinesApi::class)
class AppViewModel(
    getFeatureFlagMap: GetFeatureFlagMap,
    private val getMainNavItems: GetMainNavItems,
    private val getDetailNavigationGraphs: GetDetailNavigationGraphs,
    private val authProvider: AuthProvider,
) : ViewModel() {

    private val providers: Flow<AppStateDataBuilder.() -> Unit> =
        getFeatureFlagMap().flatMapConcat { featureFlags ->
            combine(getMainNavItems().map {
                it.mapEnabledToBuilderFunction<MainNavItem>(
                    { mainNavItems(it.sortedByDescending { it.priority }) },
                    featureFlags,
                )
            },
                getDetailNavigationGraphs().map {
                    it.mapEnabledToBuilderFunction<FeatureNavGraph>(
                        { navigationGraphs(it) },
                        featureFlags,
                    )
                },
                authProvider.getAuthState()
                    .map<AuthState, AppStateDataBuilder.() -> Unit> { authState ->
                        {
                            initialDestination(
                                if (authState.isAuthorized) null else authProvider.getAuthDestinationForState(
                                    authState
                                )
                            )
                        }
                    }) { builderFunctions ->
                { builder: AppStateDataBuilder ->
                    builder.features(featureFlags)
                    builderFunctions.forEach { it(builder) }
                }
            }
        }

    private val initial: AppState = AppState.Loading
    val state: StateFlow<AppState> = providers.map {
        appStateData {
            it()
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = initial,
    )

    private fun <T : Any> List<T>.filterFeatureFlags(map: Map<FeatureFlag, Boolean>): List<T> =
        filter { it.isFeatureEnabled { flag -> map.getOrDefault(flag, false) } }

    private fun <T : Any> List<T>.mapEnabledToBuilderFunction(
        builderFunction: AppStateDataBuilder.(List<T>) -> Unit,
        map: Map<FeatureFlag, Boolean>,
    ): AppStateDataBuilder.() -> Unit = { builderFunction(filterFeatureFlags(map)) }

}

