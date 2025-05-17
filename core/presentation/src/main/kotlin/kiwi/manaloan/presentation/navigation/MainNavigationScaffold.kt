package kiwi.manaloan.presentation.navigation

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kiwi.manaloan.feature.navigation.MainNavItem
import kotlin.reflect.KClass

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainNavigationScaffold(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    navController: NavHostController = rememberNavController(),
    mainNavItems: List<MainNavItem>,
    startDestination: KClass<*>,
    onDestinationClick: (NavHostController, MainNavItem) -> Unit,
    topBar: @Composable (String, TopAppBarScrollBehavior) -> Unit,
    builder: NavGraphBuilder.() -> Unit,
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    val topBarTitle = mainNavItems.find { destination ->
        currentDestination.isTopLevelDestinationInHierarchy(destination.destinationClass)
    }?.label ?: mainNavItems.first().label

    val topAppBarScrollBehavior = enterAlwaysScrollBehavior()

    NavigationSuiteScaffold(
        modifier = Modifier.fillMaxSize(),
        navigationSuiteItems = {
            mainNavItems.forEach { item ->
                item(
                    selected = currentDestination.isTopLevelDestinationInHierarchy(item.destinationClass),
                    onClick = { onDestinationClick(navController, item) },
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
    ) {
        Scaffold(
            topBar = { topBar(topBarTitle, topAppBarScrollBehavior) },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
        ) { paddingValues ->
            NavHost(
                modifier = modifier
                    .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                    .padding(paddingValues)
                    .consumeWindowInsets(paddingValues),
                navController = navController,
                startDestination = startDestination,
                builder = builder,
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(route: KClass<*>) =
    this?.hierarchy?.any {
        it.hasRoute(route)
    } == true
