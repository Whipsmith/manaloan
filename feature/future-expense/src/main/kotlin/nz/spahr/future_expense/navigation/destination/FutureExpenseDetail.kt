package nz.spahr.future_expense.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import nz.spahr.future_expense.presentation.FutureExpenseDetailView

@Serializable
data class FutureExpenseDetail(val id: String)

fun NavGraphBuilder.detail(){
    composable<FutureExpenseDetail>{ backStackEntry ->
        val profile: FutureExpenseDetail = backStackEntry.toRoute()
        FutureExpenseDetailView(id = profile.id)
    }
}

fun NavHostController.navigateToDetail(id: String){
    navigate(FutureExpenseDetail(id))
}