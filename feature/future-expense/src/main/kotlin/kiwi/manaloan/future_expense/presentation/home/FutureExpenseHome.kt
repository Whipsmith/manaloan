package kiwi.manaloan.future_expense.presentation.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import kiwi.manaloan.future_expense.presentation.home.view.FutureExpenseListView

@Serializable
object FutureExpenseHome

fun NavGraphBuilder.home(navigateToDetail: (String) -> Unit) {
    composable<FutureExpenseHome>{
        FutureExpenseListView(navigateToDetail = navigateToDetail)
    }
}

