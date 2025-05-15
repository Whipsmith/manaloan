package kiwi.manaLoan.future_expense.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kiwi.manaLoan.feature.navigation.FeatureNavGraph
import kiwi.manaLoan.feature_flag.FeatureFlag
import kiwi.manaLoan.feature_flag.Flagged
import kiwi.manaLoan.future_expense.feature_flags.FutureExpenseFlags
import kiwi.manaLoan.future_expense.presentation.detail.detail

class FutureExpenseFeatureNavGraph : FeatureNavGraph, Flagged {
    override val navigationGraph: NavGraphBuilder.(NavHostController) -> Unit =
        { navHostController ->
            detail()
        }

    override val featureFlag: FeatureFlag = FutureExpenseFlags.FutureExpenseFeature
}
