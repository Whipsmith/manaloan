package nz.spahr.app

import kotlinx.coroutines.flow.Flow
import nz.spahr.app.model.AppState

interface AppStateProvider {
    val appStateUpdates: Flow<(appState: AppState) -> AppState>
}