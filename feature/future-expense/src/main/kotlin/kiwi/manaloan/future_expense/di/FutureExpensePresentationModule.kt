package kiwi.manaLoan.future_expense.di

import kiwi.manaLoan.feature.navigation.FeatureNavGraph
import kiwi.manaLoan.feature.navigation.MainNavItem
import kiwi.manaLoan.future_expense.navigation.FutureExpenseFeatureNavGraph
import kiwi.manaLoan.future_expense.navigation.FutureExpenseMainNavItem
import kiwi.manaLoan.future_expense.presentation.detail.FutureExpenseDetailViewModel
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