package kiwi.autopocket.fake_auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kiwi.autopocket.fake_auth.presentation.first_launch.firstLaunch
import kiwi.autopocket.fake_auth.presentation.sign_in.SignInDestination
import kiwi.autopocket.fake_auth.presentation.sign_in.signIn
import kiwi.autopocket.feature.navigation.FeatureNavGraph

class FakeAuthNavigationGraph : FeatureNavGraph {
    override val navigationGraph: NavGraphBuilder.(NavHostController) -> Unit =
        { navHostController ->
            firstLaunch(
                navigateToSignIn = { navHostController.navigate(SignInDestination) },
                navigateToSignUp = {}
            )
            signIn()
        }
}