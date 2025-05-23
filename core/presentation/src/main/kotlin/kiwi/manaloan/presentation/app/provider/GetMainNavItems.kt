package kiwi.manaloan.presentation.app.provider

import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kiwi.manaloan.feature.navigation.MainNavItem

class GetMainNavItems(private val navItems: List<MainNavItem>) {
    operator fun invoke(): Flow<List<MainNavItem>> = flow<List<MainNavItem>> {
        emit(navItems)
        awaitCancellation()
    }

}