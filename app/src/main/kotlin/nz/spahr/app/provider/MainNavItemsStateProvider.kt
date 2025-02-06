package nz.spahr.app.provider

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import nz.spahr.app.model.AppStateDataBuilder
import nz.spahr.app.model.AppStateProvider
import nz.spahr.feature.navigation.MainNavItem

class MainNavItemsStateProvider(private val navItems: List<MainNavItem>) : AppStateProvider {
    override val updates: Flow<AppStateDataBuilder.() -> Unit>
        get() = flow<List<MainNavItem>> {
            emit(navItems)
        }.map {
            {
                mainNavItems(it)
            }
        }

}