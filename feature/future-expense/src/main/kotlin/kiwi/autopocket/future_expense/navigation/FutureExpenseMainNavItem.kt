package kiwi.autopocket.future_expense.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kiwi.apptly.feature.navigation.MainNavItem
import kiwi.apptly.feature_flag.FeatureFlag
import kiwi.apptly.feature_flag.Flagged
import kiwi.autopocket.future_expense.feature_flags.FutureExpenseFlags
import kiwi.autopocket.future_expense.presentation.detail.navigateToDetail
import kiwi.autopocket.future_expense.presentation.home.FutureExpenseHome
import kiwi.autopocket.future_expense.presentation.home.home
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