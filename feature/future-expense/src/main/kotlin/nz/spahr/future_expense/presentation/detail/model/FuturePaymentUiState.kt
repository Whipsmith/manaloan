package nz.spahr.future_expense.presentation.detail.model

import nz.spahr.future_expense.domain.entity.FuturePayment

sealed interface FuturePaymentUiState {
    data object Loading: FuturePaymentUiState
    data class Data(val detail: FuturePayment): FuturePaymentUiState
    data class Error(val errorMessage: String): FuturePaymentUiState
}