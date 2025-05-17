package kiwi.manaloan.feature.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kotlin.reflect.KClass

interface MainNavItem {
    val icon: ImageVector
    val label: String
    val destination: Any
    val destinationClass: KClass<*>
    val screen: NavGraphBuilder.(NavHostController) -> Unit
    val priority: Int
}