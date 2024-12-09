package nz.spahr.future_expense.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nz.spahr.theme.SpahrTheme

@Composable
internal fun FutureExpenseDetailView(id: String){
    Demo(id)
}

@Composable
fun Demo(id: String, modifier: Modifier = Modifier) {
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