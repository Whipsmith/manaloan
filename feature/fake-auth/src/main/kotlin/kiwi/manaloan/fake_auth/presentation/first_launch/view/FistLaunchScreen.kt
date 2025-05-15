package kiwi.manaLoan.fake_auth.presentation.first_launch.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
internal fun FirstLaunchScreen(
    navigateToSignIn: () -> Unit,
    navigateToSignUp: () -> Unit,
) {
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        Button(
            onClick = navigateToSignUp
        ) { Text("Sign up") }

        Button(
            onClick = navigateToSignIn
        ) { Text("Sign in") }
    }
}