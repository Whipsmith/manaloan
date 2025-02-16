package kiwi.autopocket.about.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kiwi.apptly.feature.navigation.FeatureNavGraph

class AboutFeatureNavGraph : FeatureNavGraph {
    override val navigationGraph: NavGraphBuilder.(NavHostController) -> Unit = {}
}