package nz.spahr.feature.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination

interface BottomNavItem {
    val icon: ImageVector
    val label: String
    val destination: Any

    fun isSelected(destination: NavDestination): Boolean
}