package nz.spahr.future_expense.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.future_expense.presentation.detail.detail
import nz.spahr.future_expense.presentation.detail.navigateToDetail
import nz.spahr.future_expense.presentation.home.home

class FutureExpenseFeatureNavGraph : FeatureNavGraph {
    override val navigationGraph: NavGraphBuilder.(NavHostController) -> Unit =
        { navHostController ->
            home(navHostController::navigateToDetail)
            detail()
        }
}
