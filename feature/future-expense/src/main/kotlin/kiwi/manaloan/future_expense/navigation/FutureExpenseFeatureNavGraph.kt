package kiwi.manaloan.future_expense.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kiwi.manaloan.feature.navigation.FeatureNavGraph
import kiwi.manaloan.feature_flag.FeatureFlag
import kiwi.manaloan.feature_flag.Flagged
import kiwi.manaloan.future_expense.feature_flags.FutureExpenseFlags
import kiwi.manaloan.future_expense.presentation.detail.detail

class FutureExpenseFeatureNavGraph : FeatureNavGraph, Flagged {
    override val navigationGraph: NavGraphBuilder.(NavHostController) -> Unit =
        { navHostController ->
            detail()
        }

    override val featureFlag: FeatureFlag = FutureExpenseFlags.FutureExpenseFeature
}
