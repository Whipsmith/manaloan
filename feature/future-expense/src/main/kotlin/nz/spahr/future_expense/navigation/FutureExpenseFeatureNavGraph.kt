package nz.spahr.future_expense.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.future_expense.navigation.destination.detail
import nz.spahr.future_expense.navigation.destination.home
import nz.spahr.future_expense.navigation.destination.navigateToDetail

class FutureExpenseFeatureNavGraph : FeatureNavGraph {
    override val navigationGraph: NavGraphBuilder.(NavHostController) -> Unit =
        { navHostController ->
            home(navHostController::navigateToDetail)
            detail()
        }
}
