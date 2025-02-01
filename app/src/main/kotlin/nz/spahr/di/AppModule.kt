package nz.spahr.di

import nz.spahr.feature_flag.FeatureFlag
import nz.spahr.future_expense.feature_flags.FutureExpenseFlags
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single(named<FeatureFlag>()) {
        listOf<FeatureFlag>(
            FutureExpenseFlags.FutureExpenseFeature,
        )
    }
}