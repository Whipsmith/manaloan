package nz.spahr.future_expense.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.vector.ImageVector
import nz.spahr.feature.navigation.MainNavItem
import nz.spahr.feature_flag.FeatureFlag
import nz.spahr.feature_flag.Flagged
import nz.spahr.future_expense.feature_flags.FutureExpenseFlags
import nz.spahr.future_expense.presentation.home.FutureExpenseHome
import kotlin.reflect.KClass

object FutureExpenseMainNavItem : MainNavItem, Flagged {
    override val icon: ImageVector = Icons.Filled.DateRange
    override val label: String = "Future Expenses"
    override val destination: Any = FutureExpenseHome
    override val destinationClass: KClass<*> = FutureExpenseHome::class

    override val featureFlag: FeatureFlag = FutureExpenseFlags.FutureExpenseFeature
}