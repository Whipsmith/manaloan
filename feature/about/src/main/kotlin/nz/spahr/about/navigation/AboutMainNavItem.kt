package nz.spahr.about.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import nz.spahr.about.presentation.home.AboutHome
import nz.spahr.feature.navigation.MainNavItem
import kotlin.reflect.KClass

object AboutMainNavItem : MainNavItem {
    override val icon: ImageVector = Icons.Filled.Info
    override val label: String = "About"
    override val destination: Any = AboutHome
    override val destinationClass: KClass<*> = AboutHome::class
}