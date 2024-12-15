package nz.spahr.di

import nz.spahr.future_expense.di.futureExpenseFeatureModule
import org.koin.dsl.module

val featureModules = module {
    includes(
        futureExpenseFeatureModule,
    )
}