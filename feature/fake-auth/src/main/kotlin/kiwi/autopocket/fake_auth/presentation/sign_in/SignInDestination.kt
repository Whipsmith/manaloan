package kiwi.autopocket.fake_auth.presentation.sign_in

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import kiwi.autopocket.fake_auth.presentation.sign_in.view.SignInScreen
import org.koin.androidx.compose.koinViewModel

@Serializable
object SignInDestination

fun NavGraphBuilder.signIn() {
    composable<SignInDestination> {
        val viewModel = koinViewModel<SignInViewModel>()
        SignInScreen(onSignIn = viewModel::onSignIn)
    }
}