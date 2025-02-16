package kiwi.autopocket.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import kiwi.autopocket.feature.navigation.MainNavItem
import kotlin.reflect.KClass

@Serializable
object MainNavigationScaffoldDestination

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.mainNavigationScaffold(
    snackbarHostState: SnackbarHostState,
    topLevelDestinations: List<MainNavItem>,
    startDestination: KClass<*>,
    onDestinationClick: (NavHostController, MainNavItem) -> Unit,
    topBar: @Composable (String, TopAppBarScrollBehavior) -> Unit,
    builder: NavGraphBuilder.() -> Unit,
) {
    composable<MainNavigationScaffoldDestination> {
        MainNavigationScaffold(
            snackbarHostState = snackbarHostState,
            mainNavItems = topLevelDestinations,
            startDestination = startDestination,
            onDestinationClick = onDestinationClick,
            topBar = topBar,
            builder = builder,
        )
    }
}