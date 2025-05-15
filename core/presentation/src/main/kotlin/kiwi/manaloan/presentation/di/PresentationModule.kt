package kiwi.manaLoan.presentation.di

import kiwi.manaLoan.auth.provider.AuthProvider
import kiwi.manaLoan.feature.navigation.FeatureNavGraph
import kiwi.manaLoan.feature.navigation.MainNavItem
import kiwi.manaLoan.feature_flag.FeatureFlag
import kiwi.manaLoan.feature_flag.FeatureFlagValueProvider
import kiwi.manaLoan.presentation.app.AppViewModel
import kiwi.manaLoan.presentation.app.provider.GetDetailNavigationGraphs
import kiwi.manaLoan.presentation.app.provider.GetFeatureFlagMap
import kiwi.manaLoan.presentation.app.provider.GetMainNavItems
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    single<GetFeatureFlagMap> {
        GetFeatureFlagMap(
            getAll<FeatureFlag>(), getAll<FeatureFlagValueProvider>()
        )
    }

    single<GetMainNavItems> { GetMainNavItems(getAll<MainNavItem>()) }

    single<GetDetailNavigationGraphs> { GetDetailNavigationGraphs(getAll<FeatureNavGraph>()) }


    viewModel {
        AppViewModel(
            get<GetFeatureFlagMap>(),
            get<GetMainNavItems>(),
            get<GetDetailNavigationGraphs>(),
            get<AuthProvider>(),
        )
    }
}