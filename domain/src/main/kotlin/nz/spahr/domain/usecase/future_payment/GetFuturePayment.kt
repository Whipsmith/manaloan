package nz.spahr.domain.usecase.future_payment

import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import nz.spahr.domain.entity.future_payment.FuturePaymentDetail
import kotlin.time.Duration.Companion.seconds

class GetFuturePayment {
    operator fun invoke(id: String): Flow<FuturePaymentDetail> {
        return flow {
            delay(3.seconds)
            emit(FuturePaymentDetail(id))
            awaitCancellation()
        }
    }
}