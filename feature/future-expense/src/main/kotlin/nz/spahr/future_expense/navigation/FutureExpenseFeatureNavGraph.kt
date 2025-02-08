package nz.spahr.future_expense.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.feature_flag.FeatureFlag
import nz.spahr.feature_flag.Flagged
import nz.spahr.future_expense.feature_flags.FutureExpenseFlags
import nz.spahr.future_expense.presentation.detail.detail

class FutureExpenseFeatureNavGraph : FeatureNavGraph, Flagged {
    override val navigationGraph: NavGraphBuilder.(NavHostController) -> Unit =
        { navHostController ->
            detail()
        }

    override val featureFlag: FeatureFlag = FutureExpenseFlags.FutureExpenseFeature
}
