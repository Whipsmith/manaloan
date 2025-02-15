package nz.spahr.di

import nz.spahr.about.di.aboutFeatureModule
import nz.spahr.fake_auth.di.fakeAuthFeatureModule
import nz.spahr.future_expense.di.futureExpenseFeatureModule
import org.koin.dsl.module

val featureModules = module {
    includes(
        futureExpenseFeatureModule,
        fakeAuthFeatureModule,
        aboutFeatureModule,
    )
}