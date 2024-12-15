package nz.spahr.future_expense.di

import nz.spahr.future_expense.presentation.detail.FutureExpenseDetailViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val futureExpensePresentationModule = module {
    viewModel { params ->
        FutureExpenseDetailViewModel(
            params.get(),
            get(),
        )
    }
}