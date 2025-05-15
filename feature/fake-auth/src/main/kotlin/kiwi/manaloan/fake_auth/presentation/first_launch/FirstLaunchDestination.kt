package kiwi.manaLoan.fake_auth.presentation.first_launch

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import kiwi.manaLoan.fake_auth.presentation.first_launch.view.FirstLaunchScreen

@Serializable
object FirstLaunchDestination

fun NavGraphBuilder.firstLaunch(
    navigateToSignIn: () -> Unit,
    navigateToSignUp: () -> Unit,
) {
    composable<FirstLaunchDestination> {
        FirstLaunchScreen(
            navigateToSignIn = navigateToSignIn,
            navigateToSignUp = navigateToSignUp,
        )
    }
}