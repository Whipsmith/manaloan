package kiwi.autopocket.domain.usecase.future_payment

import kotlinx.coroutines.flow.Flow
import kiwi.autopocket.domain.entity.future_payment.FuturePayment

class GetFuturePaymentsList {
    operator fun invoke(): Flow<List<FuturePayment>> {
        TODO()
    }
}