package kiwi.autopocket.about.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kiwi.autopocket.about.presentation.home.AboutHome
import kiwi.autopocket.about.presentation.home.home
import kiwi.apptly.feature.navigation.MainNavItem
import kotlin.reflect.KClass


object AboutMainNavItem : MainNavItem {
    override val icon: ImageVector = Icons.Filled.Info
    override val label: String = "About"
    override val destination: Any = AboutHome
    override val destinationClass: KClass<*> = AboutHome::class
    override val screen: NavGraphBuilder.(NavHostController) -> Unit = {
        home()
    }
    override val priority: Int = 0
}