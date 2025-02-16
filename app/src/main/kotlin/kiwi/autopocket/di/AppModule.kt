package kiwi.autopocket.di

import kiwi.autopocket.app.AppViewModel
import kiwi.autopocket.app.provider.GetDetailNavigationGraphs
import kiwi.autopocket.app.provider.GetFeatureFlagMap
import kiwi.autopocket.app.provider.GetMainNavItems
import kiwi.autopocket.auth.provider.AuthProvider
import kiwi.autopocket.feature.navigation.FeatureNavGraph
import kiwi.autopocket.feature.navigation.MainNavItem
import kiwi.autopocket.feature_flag.FeatureFlag
import kiwi.autopocket.feature_flag.FeatureFlagValueProvider
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

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