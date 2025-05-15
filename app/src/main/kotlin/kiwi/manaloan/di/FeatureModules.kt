package kiwi.manaLoan.di

import kiwi.manaLoan.about.di.aboutFeatureModule
import kiwi.manaLoan.fake_auth.di.fakeAuthFeatureModule
import kiwi.manaLoan.future_expense.di.futureExpenseFeatureModule
import org.koin.dsl.module

val featureModules = module {
    includes(
        futureExpenseFeatureModule,
        fakeAuthFeatureModule,
        aboutFeatureModule,
    )
}