package nz.spahr.app

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import nz.spahr.app.model.AppState
import nz.spahr.feature_flag.isFeatureEnabled
import nz.spahr.navigation.MainNavigationScaffoldDestination
import nz.spahr.navigation.mainNavigationScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SpahrApp(
    navController: NavHostController,
    appState: AppState.Data,
) {

//    SnackBar
    val snackbarHostState = remember {
        SnackbarHostState()
    }

//    TopAppBar - Make part of state?
    val topBar =
        @Composable { topBarTitle: String, topAppBarScrollBehavior: TopAppBarScrollBehavior ->
            LargeTopAppBar(
                title = {
                    Text(
                        text = topBarTitle,
                    )
                },
                scrollBehavior = topAppBarScrollBehavior,
            )
        }

    val displayItems = remember {
        derivedStateOf {
            appState.mainNavItems.filter {
                appState.isEnabledInState(it)
            }
        }
    }

    val displayStateItems = displayItems.value
    NavHost(
        navController = navController,
        startDestination = MainNavigationScaffoldDestination::class
    ) {
        mainNavigationScaffold(
            snackbarHostState = snackbarHostState,
            topLevelDestinations = displayStateItems,
            startDestination = displayStateItems.first().destinationClass,
            onDestinationClick = { homeNavHostController, mainNavItem ->
                homeNavHostController.navigate(mainNavItem.destination)
            },
            topBar = topBar,
            builder = {
                displayStateItems.forEach {
                    it.screen(this, navController)
                }
            }
        )
        appState.navigationGraphs
            .filter { appState.isEnabledInState(it) == true }
            .forEach {
                it.navigationGraph(this, navController)
            }
    }
}

private fun AppState.Data.isEnabledInState(item: Any) =
    item.isFeatureEnabled { flag -> featureMap.getOrDefault(flag, false) }

