package kiwi.manaloan.future_expense.di

import kiwi.manaloan.feature.navigation.FeatureNavGraph
import kiwi.manaloan.feature.navigation.MainNavItem
import kiwi.manaloan.future_expense.navigation.FutureExpenseFeatureNavGraph
import kiwi.manaloan.future_expense.navigation.FutureExpenseMainNavItem
import kiwi.manaloan.future_expense.presentation.detail.FutureExpenseDetailViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val futureExpensePresentationModule = module {
    viewModel { params ->
        FutureExpenseDetailViewModel(
            params.get(),
            get(),
        )
    }

    single {
        FutureExpenseFeatureNavGraph()
    } bind FeatureNavGraph::class

    single {
        FutureExpenseMainNavItem
    } bind MainNavItem::class
}