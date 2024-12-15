package nz.spahr.future_expense.domain.usecase

import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import nz.spahr.future_expense.domain.entity.FuturePayment
import kotlin.time.Duration.Companion.seconds

class GetFuturePayment {
    operator fun invoke(id: String): Flow<FuturePayment> {
        return flow {
            delay(3.seconds)
            emit(FuturePayment(id))
            awaitCancellation()
        }
    }
}