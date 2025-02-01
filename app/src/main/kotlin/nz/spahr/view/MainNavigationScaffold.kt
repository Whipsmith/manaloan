package nz.spahr.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import nz.spahr.feature.navigation.MainNavItem
import nz.spahr.feature_flag.isFeatureEnabled
import nz.spahr.model.AppState
import org.koin.compose.koinInject
import org.koin.core.qualifier.named

@Composable
internal fun MainNavigationScaffold(
    navController: NavHostController,
    appState: AppState,
    navHost: @Composable (List<MainNavItem>) -> Unit,
) {
    val mainNavItems: List<MainNavItem> = koinInject(named<MainNavItem>())
    var currentBackStackEntry =
        navController.currentBackStackEntryAsState().value
    val currentDestination: NavDestination? =
        currentBackStackEntry?.destination
    val adaptiveInfo = currentWindowAdaptiveInfo()
    val customNavSuiteType = with(adaptiveInfo) {
        val calculatedType = NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
        val displayNavBar = mainNavItems.any { item ->
            currentDestination?.hasRoute(item.destinationClass) == true
        }
        if (shouldDisplayNavUI(displayNavBar, calculatedType)) {
            calculatedType
        } else {
            NavigationSuiteType.None
        }
    }
    val displayItems = remember {
        derivedStateOf {
            mainNavItems.filter {
                it.isFeatureEnabled { flag -> appState.featureMap.getOrDefault(flag, false) }
            }
        }
    }

    NavigationSuiteScaffold(
        modifier = Modifier.fillMaxSize(),
        layoutType = customNavSuiteType,
        navigationSuiteItems = {
            displayItems.value.forEach { item ->
                item(
                    selected = currentDestination.isChildOf(item),
                    onClick = { navController.navigate(item.destination) },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label
                        )
                    },
                    label = { Text(text = item.label) }
                )
            }
        },
        content = { navHost(displayItems.value) },
    )
}

private fun shouldDisplayNavUI(
    displayNavBar: Boolean,
    calculatedType: NavigationSuiteType
): Boolean =
    displayNavBar || calculatedType == NavigationSuiteType.NavigationRail || calculatedType == NavigationSuiteType.NavigationDrawer

private fun NavDestination?.isChildOf(mainNavItem: MainNavItem) = this?.let {
    mainNavItem.containsDestination(it)
} == true

private fun MainNavItem.containsDestination(navDestination: NavDestination) =
    navDestination.hierarchy.any {
        it.hasRoute(this.destinationClass)
    }