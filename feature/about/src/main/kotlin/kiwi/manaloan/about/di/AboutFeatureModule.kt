package kiwi.manaLoan.about.di

import kiwi.manaLoan.about.navigation.AboutFeatureNavGraph
import kiwi.manaLoan.about.navigation.AboutMainNavItem
import kiwi.manaLoan.feature.navigation.FeatureNavGraph
import kiwi.manaLoan.feature.navigation.MainNavItem
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