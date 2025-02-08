package nz.spahr.fake_auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import nz.spahr.fake_auth.presentation.first_launch.firstLaunch
import nz.spahr.fake_auth.presentation.sign_in.SignInDestination
import nz.spahr.fake_auth.presentation.sign_in.signIn
import nz.spahr.feature.navigation.FeatureNavGraph

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