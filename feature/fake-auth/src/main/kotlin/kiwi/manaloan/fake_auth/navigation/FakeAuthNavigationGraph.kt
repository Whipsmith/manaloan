package kiwi.manaloan.fake_auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kiwi.manaloan.fake_auth.presentation.first_launch.firstLaunch
import kiwi.manaloan.fake_auth.presentation.sign_in.SignInDestination
import kiwi.manaloan.fake_auth.presentation.sign_in.signIn
import kiwi.manaloan.feature.navigation.FeatureNavGraph

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