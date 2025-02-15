package nz.spahr.di

import nz.spahr.app.AppViewModel
import nz.spahr.app.provider.GetDetailNavigationGraphs
import nz.spahr.app.provider.GetFeatureFlagMap
import nz.spahr.app.provider.GetMainNavItems
import nz.spahr.auth.provider.AuthProvider
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.feature.navigation.MainNavItem
import nz.spahr.feature_flag.FeatureFlag
import nz.spahr.feature_flag.FeatureFlagValueProvider
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