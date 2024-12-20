package nz.spahr.future_expense.di

import nz.spahr.domain.usecase.future_payment.GetFuturePayment
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val futureExpenseDomainModule = module {
    factoryOf(::GetFuturePayment)
}