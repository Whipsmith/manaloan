package nz.spahr.future_expense.di

import org.koin.dsl.module

val futureExpenseFeatureModule = module {
    includes(
        futureExpensePresentationModule,
        futureExpenseDomainModule,
    )
}