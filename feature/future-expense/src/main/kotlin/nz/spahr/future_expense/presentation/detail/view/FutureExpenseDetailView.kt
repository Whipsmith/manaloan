package nz.spahr.future_expense.presentation.detail.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nz.spahr.future_expense.presentation.detail.model.FuturePaymentUiState
import nz.spahr.theme.SpahrTheme

@Composable
internal fun FutureExpenseDetailView(state: FuturePaymentUiState) {
    when (state) {
        is FuturePaymentUiState.Data -> {
            Demo(state.detail.id)
        }

        is FuturePaymentUiState.Error -> {
            Text(state.errorMessage)
        }

        FuturePaymentUiState.Loading -> {
            Text("Loading...")
        }
    }
//    Demo(id)
}

@Composable
fun Demo(id: String, modifier: Modifier = Modifier.Companion) {
    Text(
        text = "Future expense detail for id: $id",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DemoPreview() {
    SpahrTheme {
        Demo("Android")
    }
}