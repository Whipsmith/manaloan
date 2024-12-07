package nz.spahr.di

import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.future_expense.navigation.FutureExpenseFeatureNavGraph
import org.koin.dsl.module

val navigationModule = module {
    single {
        listOf<FeatureNavGraph>(
            FutureExpenseFeatureNavGraph(),
        )
    }
}