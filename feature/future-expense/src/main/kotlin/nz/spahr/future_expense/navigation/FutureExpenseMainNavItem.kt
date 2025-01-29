package nz.spahr.future_expense.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.vector.ImageVector
import nz.spahr.feature.navigation.MainNavItem
import nz.spahr.future_expense.presentation.home.FutureExpenseHome
import kotlin.reflect.KClass

object FutureExpenseMainNavItem : MainNavItem {
    override val icon: ImageVector = Icons.Filled.DateRange
    override val label: String = "Future Expenses"
    override val destination: Any = FutureExpenseHome
    override val destinationClass: KClass<*> = FutureExpenseHome::class
}