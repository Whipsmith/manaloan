package nz.spahr.future_expense.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import nz.spahr.future_expense.presentation.FutureExpenseHomeView

@Serializable
object FutureExpenseHome

fun NavGraphBuilder.home(){
    composable<FutureExpenseHome>{
        FutureExpenseHomeView()
    }
}

