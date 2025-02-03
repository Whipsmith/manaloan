package nz.spahr.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import nz.spahr.app.model.AppState
import nz.spahr.view.MainNavHost
import nz.spahr.view.MainNavigationScaffold

@Composable
internal fun SpahrApp(appState: AppState.Data) {
    val navController = rememberNavController()


//                    TODO: Wrap this in a scaffold to house nav drawer and account image? (See google photos)

    MainNavigationScaffold(
        navController = navController,
        navHost = @Composable {
            MainNavHost(navController = navController, startDestinations = it)
        },
        appState = appState,
    )
}