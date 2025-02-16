package kiwi.autopocket.future_expense.di

import kiwi.autopocket.feature.navigation.FeatureNavGraph
import kiwi.autopocket.feature.navigation.MainNavItem
import kiwi.autopocket.future_expense.navigation.FutureExpenseFeatureNavGraph
import kiwi.autopocket.future_expense.navigation.FutureExpenseMainNavItem
import kiwi.autopocket.future_expense.presentation.detail.FutureExpenseDetailViewModel
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