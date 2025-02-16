package kiwi.autopocket.app

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import kiwi.autopocket.app.model.AppState
import kiwi.autopocket.navigation.MainNavigationScaffoldDestination
import kiwi.autopocket.navigation.mainNavigationScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AutopocketApp(
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

    NavHost(
        navController = navController,
        startDestination = appState.initialDestination ?: MainNavigationScaffoldDestination::class
    ) {
        mainNavigationScaffold(
            snackbarHostState = snackbarHostState,
            topLevelDestinations = appState.mainNavItems,
            startDestination = appState.mainNavItems.first().destinationClass,
            onDestinationClick = { homeNavHostController, mainNavItem ->
                homeNavHostController.navigate(mainNavItem.destination)
            },
            topBar = topBar,
            builder = {
                appState.mainNavItems.forEach {
                    it.screen(this, navController)
                }
            }
        )
        appState.navigationGraphs
            .forEach {
                it.navigationGraph(this, navController)
            }
    }
}


