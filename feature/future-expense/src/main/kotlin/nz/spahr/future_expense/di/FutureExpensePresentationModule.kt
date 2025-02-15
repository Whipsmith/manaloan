package nz.spahr.future_expense.di

import nz.spahr.feature.navigation.FeatureNavGraph
import nz.spahr.feature.navigation.MainNavItem
import nz.spahr.future_expense.navigation.FutureExpenseFeatureNavGraph
import nz.spahr.future_expense.navigation.FutureExpenseMainNavItem
import nz.spahr.future_expense.presentation.detail.FutureExpenseDetailViewModel
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