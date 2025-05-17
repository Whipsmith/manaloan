package kiwi.manaloan.about.di

import kiwi.manaloan.about.navigation.AboutFeatureNavGraph
import kiwi.manaloan.about.navigation.AboutMainNavItem
import kiwi.manaloan.feature.navigation.FeatureNavGraph
import kiwi.manaloan.feature.navigation.MainNavItem
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