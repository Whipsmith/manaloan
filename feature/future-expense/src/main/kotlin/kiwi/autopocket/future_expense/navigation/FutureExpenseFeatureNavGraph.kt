package kiwi.autopocket.future_expense.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kiwi.autopocket.feature.navigation.FeatureNavGraph
import kiwi.autopocket.feature_flag.FeatureFlag
import kiwi.autopocket.feature_flag.Flagged
import kiwi.autopocket.future_expense.feature_flags.FutureExpenseFlags
import kiwi.autopocket.future_expense.presentation.detail.detail

class FutureExpenseFeatureNavGraph : FeatureNavGraph, Flagged {
    override val navigationGraph: NavGraphBuilder.(NavHostController) -> Unit =
        { navHostController ->
            detail()
        }

    override val featureFlag: FeatureFlag = FutureExpenseFlags.FutureExpenseFeature
}
