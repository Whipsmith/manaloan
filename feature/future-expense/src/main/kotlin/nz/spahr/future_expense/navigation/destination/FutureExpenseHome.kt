package nz.spahr.future_expense.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import nz.spahr.future_expense.presentation.FutureExpenseHomeView

@Serializable
object FutureExpenseHome

fun NavGraphBuilder.home(navigateToDetail: (String) -> Unit) {
    composable<FutureExpenseHome>{
        FutureExpenseHomeView(navigateToDetail = navigateToDetail)
    }
}

