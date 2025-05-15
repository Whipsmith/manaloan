package kiwi.manaLoan.fake_auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kiwi.manaLoan.fake_auth.presentation.first_launch.firstLaunch
import kiwi.manaLoan.fake_auth.presentation.sign_in.SignInDestination
import kiwi.manaLoan.fake_auth.presentation.sign_in.signIn
import kiwi.manaLoan.feature.navigation.FeatureNavGraph

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