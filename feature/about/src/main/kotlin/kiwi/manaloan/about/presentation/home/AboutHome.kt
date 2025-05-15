package kiwi.manaLoan.about.presentation.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import kiwi.manaLoan.about.presentation.home.view.AboutHomeView

@Serializable
object AboutHome

fun NavGraphBuilder.home() {
    composable<AboutHome> {
        AboutHomeView()
    }
}