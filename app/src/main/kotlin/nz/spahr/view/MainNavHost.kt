package nz.spahr.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.feature.navigation.MainNavItem
import org.koin.compose.koinInject
import org.koin.core.qualifier.named

@Composable
internal fun MainNavHost(navController: NavHostController, startDestinations: List<MainNavItem>) {
    val featureGraphs: List<FeatureNavGraph> = koinInject(named<FeatureNavGraph>())
    NavHost(
        navController = navController,
        startDestination = startDestinations.first().destination,
        modifier = Modifier,
    ) {
        featureGraphs.forEach { feature ->
            feature.navigationGraph(this, navController)
        }
    }
}