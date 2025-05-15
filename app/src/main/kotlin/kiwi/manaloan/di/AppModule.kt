package kiwi.manaLoan.di

import kiwi.manaLoan.presentation.di.presentationModule
import org.koin.dsl.module

val appModule = module {
    includes(presentationModule)
}