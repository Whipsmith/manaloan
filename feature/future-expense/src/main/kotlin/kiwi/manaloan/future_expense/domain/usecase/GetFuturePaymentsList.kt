package kiwi.manaloan.future_expense.domain.usecase

import kiwi.manaloan.future_expense.domain.entity.FuturePayment
import kotlinx.coroutines.flow.Flow

class GetFuturePaymentsList {
    operator fun invoke(): Flow<List<FuturePayment>> {
        TODO()
    }
}