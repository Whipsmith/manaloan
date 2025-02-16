package kiwi.autopocket.future_expense.di

import kiwi.autopocket.feature_flag.FeatureFlag
import kiwi.autopocket.feature_flag.FeatureFlagValueProvider
import kiwi.autopocket.future_expense.feature_flags.FutureExpenseFlags
import org.koin.dsl.bind
import org.koin.dsl.module

val futureExpenseFeatureModule = module {
    includes(
        futureExpensePresentationModule,
        futureExpenseDomainModule,
    )

    single {
        FutureExpenseFlags.FutureExpenseFeature
    } bind FeatureFlag::class

    single {
        FutureExpenseFlags
    } bind FeatureFlagValueProvider::class
}