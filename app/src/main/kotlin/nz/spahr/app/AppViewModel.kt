package nz.spahr.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.stateIn
import nz.spahr.app.model.AppState

class AppViewModel(appStateProviders: List<AppStateProvider>) : ViewModel() {

    private val providers: Flow<(AppState) -> AppState> = merge(
        *appStateProviders.map { it.appStateUpdates }.toTypedArray()
    )
    private val initial: AppState = AppState.Loading
    val state: StateFlow<AppState> =
        providers.scan(initial) { acc, value ->
            value(acc)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = initial,
        )
}
