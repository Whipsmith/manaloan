package nz.spahr.app.model

import kotlinx.coroutines.flow.Flow

interface AppStateProvider {
    val updates: Flow<AppStateDataBuilder.() -> Unit>
}