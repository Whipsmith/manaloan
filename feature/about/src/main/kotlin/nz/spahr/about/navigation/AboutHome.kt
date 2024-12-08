package nz.spahr.about.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import nz.spahr.about.presentation.AboutHomeView

@Serializable
object AboutHome

fun NavGraphBuilder.home(){
    composable<AboutHome>{
        AboutHomeView()
    }
}