package nz.spahr.di

import nz.spahr.about.navigation.AboutBottomNavItem
import nz.spahr.about.navigation.AboutFeatureNavGraph
import nz.spahr.feature.navigation.BottomNavItem
import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.future_expense.navigation.FutureExpenseBottomNavItem
import nz.spahr.future_expense.navigation.FutureExpenseFeatureNavGraph
import org.koin.core.qualifier.named
import org.koin.dsl.module

val navigationModule = module {
    single(named<FeatureNavGraph>()) {
        listOf<FeatureNavGraph>(
            FutureExpenseFeatureNavGraph(),
            AboutFeatureNavGraph(),
        )
    }
    single(named<BottomNavItem>()){
        listOf<BottomNavItem>(
            FutureExpenseBottomNavItem,
            AboutBottomNavItem,
        )
    }
}