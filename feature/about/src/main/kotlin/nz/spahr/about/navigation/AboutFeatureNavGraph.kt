package nz.spahr.about.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import nz.spahr.about.presentation.home.home
import nz.spahr.feature.navigation.FeatureNavGraph

class AboutFeatureNavGraph : FeatureNavGraph {
    override val navigationGraph: NavGraphBuilder.(NavHostController) -> Unit = {
        home()
    }
}