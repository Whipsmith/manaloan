package kiwi.manaLoan.future_expense.presentation.detail.model

import kiwi.manaLoan.future_expense.domain.entity.FuturePaymentDetail

sealed interface FuturePaymentUiState {
    data object Loading : FuturePaymentUiState
    data class Data(val detail: FuturePaymentDetail) : FuturePaymentUiState
    data class Error(val errorMessage: String) : FuturePaymentUiState
}