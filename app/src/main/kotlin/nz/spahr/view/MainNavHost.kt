package nz.spahr.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.future_expense.presentation.home.FutureExpenseHome
import org.koin.compose.koinInject
import org.koin.core.qualifier.named

@Composable
internal fun MainNavHost(navController: NavHostController) {
    val featureGraphs: List<FeatureNavGraph> = koinInject(named<FeatureNavGraph>())
    NavHost(
        navController = navController,
        startDestination = FutureExpenseHome,
        modifier = Modifier,
    ) {
        featureGraphs.forEach { feature ->
            feature.navigationGraph(this, navController)
        }
    }
}