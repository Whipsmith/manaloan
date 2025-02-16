package kiwi.autopocket.about.presentation.home.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kiwi.autopocket.theme.AutoPocketTheme

@Composable
internal fun AboutHomeView() {
    About()
}

@Composable
fun About(modifier: Modifier = Modifier.Companion) {
    Text(
        text = "This is the about view",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AutoPocketTheme {
        About()
    }
}