package kiwi.apptly.presentation.app.model

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import kiwi.apptly.feature.navigation.FeatureNavGraph
import kiwi.apptly.feature.navigation.MainNavItem
import kiwi.apptly.feature_flag.FeatureFlag
import kotlin.reflect.KClass


@Stable
sealed interface AppState {
    data object Loading : AppState
    data class Data(
        val featureMap: ImmutableMap<FeatureFlag, Boolean>,
        val mainNavItems: List<MainNavItem>,
        val navigationGraphs: ImmutableList<FeatureNavGraph>,
        val initialDestination: KClass<*>?,
    ) : AppState
}

class AppStateDataBuilder {
    private val featureMapBuilder = mutableMapOf<FeatureFlag, Boolean>()
    private var navItemsBuilder: List<MainNavItem>? = null
    private val navGraphsBuilder = mutableListOf<FeatureNavGraph>()
    private var initialDestinationBuilder: KClass<*>? = null

    fun features(flags: Map<FeatureFlag, Boolean>) {
        featureMapBuilder.putAll(flags)
    }

    fun mainNavItems(mainNavItems: List<MainNavItem>) {
        navItemsBuilder = mainNavItems
    }

    fun navigationGraphs(featureGraphs: List<FeatureNavGraph>) {
        navGraphsBuilder.addAll(featureGraphs)
    }

    fun initialDestination(destination: KClass<*>?) {
        initialDestinationBuilder = destination
    }

    fun build(): AppState.Data {
        requireNotNull(navItemsBuilder) { "Main nav items must be set" }
        return AppState.Data(
            featureMap = featureMapBuilder.toImmutableMap(),
            mainNavItems = navItemsBuilder!!,
            navigationGraphs = navGraphsBuilder.toImmutableList(),
            initialDestination = initialDestinationBuilder
        )
    }
}

fun appStateData(block: AppStateDataBuilder.() -> Unit): AppState.Data {
    return AppStateDataBuilder().apply(block).build()
}