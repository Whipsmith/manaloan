package kiwi.autopocket.future_expense.presentation.detail.model

import kiwi.autopocket.domain.entity.future_payment.FuturePaymentDetail

sealed interface FuturePaymentUiState {
    data object Loading : FuturePaymentUiState
    data class Data(val detail: FuturePaymentDetail) : FuturePaymentUiState
    data class Error(val errorMessage: String) : FuturePaymentUiState
}