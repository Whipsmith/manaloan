package nz.spahr.di

import nz.spahr.app.AppStateProvider
import nz.spahr.app.AppViewModel
import nz.spahr.app.provider.AppStateFeatureFlagProvider
import nz.spahr.feature_flag.FeatureFlag
import nz.spahr.feature_flag.FeatureFlagValueProvider
import nz.spahr.future_expense.feature_flags.FutureExpenseFlags
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single(named<FeatureFlag>()) {
        listOf<FeatureFlag>(
            FutureExpenseFlags.FutureExpenseFeature,
        )
    }

    single(named<FeatureFlagValueProvider>()) {
        listOf<FeatureFlagValueProvider>(
            FutureExpenseFlags
        )
    }
    single<FeatureFlag> { FutureExpenseFlags.FutureExpenseFeature }
    single<FeatureFlagValueProvider> { FutureExpenseFlags }

    single<AppStateProvider> {
        AppStateFeatureFlagProvider(
            getAll<FeatureFlag>(), getAll<FeatureFlagValueProvider>()
        )
    }

    viewModel {
        AppViewModel(getAll<AppStateProvider>())
    }
}