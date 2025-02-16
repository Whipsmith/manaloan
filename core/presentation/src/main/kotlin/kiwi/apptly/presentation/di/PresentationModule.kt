package kiwi.apptly.presentation.di

import kiwi.apptly.auth.provider.AuthProvider
import kiwi.apptly.feature.navigation.FeatureNavGraph
import kiwi.apptly.feature.navigation.MainNavItem
import kiwi.apptly.feature_flag.FeatureFlag
import kiwi.apptly.feature_flag.FeatureFlagValueProvider
import kiwi.apptly.presentation.app.AppViewModel
import kiwi.apptly.presentation.app.provider.GetDetailNavigationGraphs
import kiwi.apptly.presentation.app.provider.GetFeatureFlagMap
import kiwi.apptly.presentation.app.provider.GetMainNavItems
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