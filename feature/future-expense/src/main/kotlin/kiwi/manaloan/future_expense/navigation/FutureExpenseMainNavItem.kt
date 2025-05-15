package kiwi.manaLoan.future_expense.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kiwi.manaLoan.feature.navigation.MainNavItem
import kiwi.manaLoan.feature_flag.FeatureFlag
import kiwi.manaLoan.feature_flag.Flagged
import kiwi.manaLoan.future_expense.feature_flags.FutureExpenseFlags
import kiwi.manaLoan.future_expense.presentation.detail.navigateToDetail
import kiwi.manaLoan.future_expense.presentation.home.FutureExpenseHome
import kiwi.manaLoan.future_expense.presentation.home.home
import kotlin.reflect.KClass

object FutureExpenseMainNavItem : MainNavItem, Flagged {
    override val icon: ImageVector = Icons.Filled.DateRange
    override val label: String = "Future Expenses"
    override val destination: Any = FutureExpenseHome
    override val destinationClass: KClass<*> = FutureExpenseHome::class
    override val screen: NavGraphBuilder.(NavHostController) -> Unit = { navHostController ->
        home(navHostController::navigateToDetail)
    }

    override val featureFlag: FeatureFlag = FutureExpenseFlags.FutureExpenseFeature

    override val priority: Int = 4
}