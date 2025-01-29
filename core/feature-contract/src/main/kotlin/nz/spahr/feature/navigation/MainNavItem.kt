package nz.spahr.feature.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import kotlin.reflect.KClass

interface MainNavItem {
    val icon: ImageVector
    val label: String
    val destination: Any
    val destinationClass: KClass<*>
}