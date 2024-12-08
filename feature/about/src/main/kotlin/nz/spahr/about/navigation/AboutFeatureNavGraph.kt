package nz.spahr.about.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.about.navigation.home

class AboutFeatureNavGraph: FeatureNavGraph {
    override val navigationGraph: NavGraphBuilder.(NavHostController) -> Unit = {
        home()
    }
}