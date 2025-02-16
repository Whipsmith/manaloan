package kiwi.autopocket.presentation.di

import kiwi.autopocket.auth.provider.AuthProvider
import kiwi.autopocket.feature.navigation.FeatureNavGraph
import kiwi.autopocket.feature.navigation.MainNavItem
import kiwi.autopocket.feature_flag.FeatureFlag
import kiwi.autopocket.feature_flag.FeatureFlagValueProvider
import kiwi.autopocket.presentation.app.AppViewModel
import kiwi.autopocket.presentation.app.provider.GetDetailNavigationGraphs
import kiwi.autopocket.presentation.app.provider.GetFeatureFlagMap
import kiwi.autopocket.presentation.app.provider.GetMainNavItems
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