package kiwi.autopocket.about.di

import kiwi.autopocket.about.navigation.AboutFeatureNavGraph
import kiwi.autopocket.about.navigation.AboutMainNavItem
import kiwi.apptly.feature.navigation.FeatureNavGraph
import kiwi.apptly.feature.navigation.MainNavItem
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