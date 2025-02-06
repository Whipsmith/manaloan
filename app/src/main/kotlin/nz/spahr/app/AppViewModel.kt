package nz.spahr.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import nz.spahr.app.model.AppState
import nz.spahr.app.model.AppStateDataBuilder
import nz.spahr.app.model.AppStateProvider
import nz.spahr.app.model.appStateData

class AppViewModel(
    stateProviders: List<AppStateProvider>
) : ViewModel() {
    private val providers: Flow<AppStateDataBuilder.() -> Unit> =
        combine(stateProviders.map { it.updates }) { builderFunctions ->
            { builder: AppStateDataBuilder ->
                builderFunctions.forEach { it(builder) }
            }
        }
    private val initial: AppState = AppState.Loading
    val state: StateFlow<AppState> =
        providers.map {
            appStateData {
                it()
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = initial,
        )
}
