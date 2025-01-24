package nz.spahr.di

import nz.spahr.about.navigation.AboutFeatureNavGraph
import nz.spahr.about.navigation.AboutMainNavItem
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.feature.navigation.MainNavItem
import nz.spahr.future_expense.navigation.FutureExpenseFeatureNavGraph
import nz.spahr.future_expense.navigation.FutureExpenseMainNavItem
import org.koin.core.qualifier.named
import org.koin.dsl.module

val navigationModule = module {
    single(named<FeatureNavGraph>()) {
        listOf<FeatureNavGraph>(
            FutureExpenseFeatureNavGraph(),
            AboutFeatureNavGraph(),
        )
    }
    single(named<MainNavItem>()) {
        listOf<MainNavItem>(
            FutureExpenseMainNavItem,
            AboutMainNavItem,
        )
    }
}