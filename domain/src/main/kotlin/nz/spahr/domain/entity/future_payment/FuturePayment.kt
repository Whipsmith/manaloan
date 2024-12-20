package nz.spahr.domain.entity.future_payment

import java.math.BigDecimal
import java.time.Instant

data class FuturePayment(
    val id: String,
    val name: String,
    val amount: BigDecimal,
    val nextDueDate: Instant,
)
