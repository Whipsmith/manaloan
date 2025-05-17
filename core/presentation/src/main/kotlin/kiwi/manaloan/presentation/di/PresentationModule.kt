package kiwi.manaloan.presentation.di

import kiwi.manaloan.auth.provider.AuthProvider
import kiwi.manaloan.feature.navigation.FeatureNavGraph
import kiwi.manaloan.feature.navigation.MainNavItem
import kiwi.manaloan.feature_flag.FeatureFlag
import kiwi.manaloan.feature_flag.FeatureFlagValueProvider
import kiwi.manaloan.presentation.app.AppViewModel
import kiwi.manaloan.presentation.app.provider.GetDetailNavigationGraphs
import kiwi.manaloan.presentation.app.provider.GetFeatureFlagMap
import kiwi.manaloan.presentation.app.provider.GetMainNavItems
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