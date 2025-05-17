package kiwi.manaloan.di

import kiwi.manaloan.about.di.aboutFeatureModule
import kiwi.manaloan.fake_auth.di.fakeAuthFeatureModule
import kiwi.manaloan.future_expense.di.futureExpenseFeatureModule
import org.koin.dsl.module

val featureModules = module {
    includes(
        futureExpenseFeatureModule,
        fakeAuthFeatureModule,
        aboutFeatureModule,
    )
}