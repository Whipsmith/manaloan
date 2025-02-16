package kiwi.autopocket.future_expense.presentation.detail

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import kiwi.autopocket.future_expense.presentation.detail.view.FutureExpenseDetailView
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Serializable
data class FutureExpenseDetail(val id: String)

fun NavGraphBuilder.detail() {
    composable<FutureExpenseDetail> { backStackEntry ->
        val expense: FutureExpenseDetail = backStackEntry.toRoute()
        val viewModel: FutureExpenseDetailViewModel = koinViewModel { parametersOf(expense.id) }
        val state = viewModel.state.collectAsStateWithLifecycle()
        FutureExpenseDetailView(state = state.value)
    }
}

fun NavHostController.navigateToDetail(id: String) {
    navigate(FutureExpenseDetail(id))
}