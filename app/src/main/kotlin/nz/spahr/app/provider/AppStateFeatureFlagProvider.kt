package nz.spahr.app.provider

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toPersistentHashMap
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import nz.spahr.app.AppStateProvider
import nz.spahr.app.model.AppState
import nz.spahr.app.model.AppState.*
import nz.spahr.feature_flag.FeatureFlag
import nz.spahr.feature_flag.FeatureFlagValueProvider

class AppStateFeatureFlagProvider(
    private val featureFlags: List<FeatureFlag>,
    private val featureFlagValueProviders: List<FeatureFlagValueProvider>,
) : AppStateProvider {
    override val appStateUpdates: Flow<(AppState) -> AppState>
        get() = flow<ImmutableMap<FeatureFlag, Boolean>> {
            emit(
                featureFlags.associateWith { getValue(it) }
                    .toPersistentHashMap()
            )
        }.map { featureMap ->
            { appState: AppState ->
                when (appState) {
                    Loading -> Data(
                        featureMap = featureMap
                    )

                    is Data -> appState.copy(featureMap = featureMap)
                }
            }
        }

    private suspend fun getValue(featureFlag: FeatureFlag) =
        featureFlagValueProviders.sortedBy { it.priority }
            .firstNotNullOfOrNull { it.isFlagEnabled(featureFlag) } == true
}