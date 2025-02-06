package nz.spahr.di

import nz.spahr.app.AppViewModel
import nz.spahr.app.provider.GetDetailNavigationGraphs
import nz.spahr.app.provider.GetFeatureFlagMap
import nz.spahr.app.provider.GetMainNavItems
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.feature.navigation.MainNavItem
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

    single<GetFeatureFlagMap> {
        GetFeatureFlagMap(
            getAll<FeatureFlag>(), getAll<FeatureFlagValueProvider>()
        )
    }

    single<GetMainNavItems> { GetMainNavItems(get(named<MainNavItem>())) }

    single<GetDetailNavigationGraphs> { GetDetailNavigationGraphs(get(named<FeatureNavGraph>())) }


    viewModel {
        AppViewModel(
            get(),
            get(),
            get(),
        )
    }
}