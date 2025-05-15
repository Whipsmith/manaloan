package kiwi.manaLoan.future_expense.domain.usecase

import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kiwi.manaLoan.future_expense.domain.entity.FuturePaymentDetail
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