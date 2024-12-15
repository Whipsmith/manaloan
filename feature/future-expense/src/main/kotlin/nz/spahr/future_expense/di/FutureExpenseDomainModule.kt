package nz.spahr.future_expense.di

import nz.spahr.future_expense.domain.usecase.GetFuturePayment
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val futureExpenseDomainModule = module {
    factoryOf(::GetFuturePayment)
}