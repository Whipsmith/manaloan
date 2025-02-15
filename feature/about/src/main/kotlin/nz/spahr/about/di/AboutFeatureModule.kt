package nz.spahr.about.di

import nz.spahr.about.navigation.AboutFeatureNavGraph
import nz.spahr.about.navigation.AboutMainNavItem
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.feature.navigation.MainNavItem
import org.koin.dsl.bind
import org.koin.dsl.module

val aboutFeatureModule = module {

    single {
        AboutFeatureNavGraph()
    } bind FeatureNavGraph::class

    single {
        AboutMainNavItem
    } bind MainNavItem::class
}