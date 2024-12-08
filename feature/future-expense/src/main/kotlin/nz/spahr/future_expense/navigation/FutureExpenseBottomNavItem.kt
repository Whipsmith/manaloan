package nz.spahr.future_expense.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import nz.spahr.feature.navigation.BottomNavItem

object FutureExpenseBottomNavItem : BottomNavItem {
    override val icon: ImageVector = Icons.Filled.DateRange
    override val label: String = "Future Payments"
    override val destination: Any = FutureExpenseHome
    override fun isSelected(destination: NavDestination) = destination.hierarchy.any {
        it.hasRoute<FutureExpenseHome>()
    }
}