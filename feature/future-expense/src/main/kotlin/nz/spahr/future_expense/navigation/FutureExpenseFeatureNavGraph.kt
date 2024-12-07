package nz.spahr.future_expense.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import nz.spahr.feature.navigation.FeatureNavGraph

class FutureExpenseFeatureNavGraph : FeatureNavGraph {
    override val navigationGraph: NavGraphBuilder.(NavHostController) -> Unit = {
        home()
    }
}
