package nz.spahr.future_expense.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import nz.spahr.future_expense.domain.usecase.GetFuturePayment
import nz.spahr.future_expense.presentation.detail.model.FuturePaymentUiState

class FutureExpenseDetailViewModel(
    private val id: String,
    private val getFuturePayment: GetFuturePayment,
) : ViewModel() {

    val state: StateFlow<FuturePaymentUiState> = flow<FuturePaymentUiState> {
        emitAll(
            getFuturePayment(id = id)
                .map {
                    FuturePaymentUiState.Data(it)
                }
        )
    }.catch { error ->
        FuturePaymentUiState.Error(error.message.orEmpty())
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), FuturePaymentUiState.Loading)
}