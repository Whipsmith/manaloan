package nz.spahr.domain.usecase.future_payment

import kotlinx.coroutines.flow.Flow
import nz.spahr.domain.entity.future_payment.FuturePayment

class GetFuturePaymentsList {
    operator fun invoke(): Flow<List<FuturePayment>> {
        TODO()
    }
}