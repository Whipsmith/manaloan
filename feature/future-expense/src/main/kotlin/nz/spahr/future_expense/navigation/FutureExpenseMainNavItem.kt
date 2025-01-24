package nz.spahr.future_expense.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import nz.spahr.feature.navigation.MainNavItem
import nz.spahr.future_expense.presentation.home.FutureExpenseHome

object FutureExpenseMainNavItem : MainNavItem {
    override val icon: ImageVector = Icons.Filled.DateRange
    override val label: String = "Future Expenses"
    override val destination: Any = FutureExpenseHome
    override fun isSelected(destination: NavDestination) = destination.hasRoute<FutureExpenseHome>()
}