package kiwi.autopocket.di

import kiwi.autopocket.about.di.aboutFeatureModule
import kiwi.autopocket.fake_auth.di.fakeAuthFeatureModule
import kiwi.autopocket.future_expense.di.futureExpenseFeatureModule
import org.koin.dsl.module

val featureModules = module {
    includes(
        futureExpenseFeatureModule,
        fakeAuthFeatureModule,
        aboutFeatureModule,
    )
}