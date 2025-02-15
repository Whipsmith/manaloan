package nz.spahr.future_expense.di

import nz.spahr.feature_flag.FeatureFlag
import nz.spahr.feature_flag.FeatureFlagValueProvider
import nz.spahr.future_expense.feature_flags.FutureExpenseFlags
import org.koin.dsl.module

val futureExpenseFeatureModule = module {
    includes(
        futureExpensePresentationModule,
        futureExpenseDomainModule,
    )

    single<FeatureFlag> {
        FutureExpenseFlags.FutureExpenseFeature
    }

    single<FeatureFlagValueProvider> {
        FutureExpenseFlags
    }
}