package kiwi.manaloan.about.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kiwi.manaloan.feature.navigation.FeatureNavGraph

class AboutFeatureNavGraph : FeatureNavGraph {
    override val navigationGraph: NavGraphBuilder.(NavHostController) -> Unit = {}
}