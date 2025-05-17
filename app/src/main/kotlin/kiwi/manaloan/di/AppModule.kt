package kiwi.manaloan.di

import kiwi.manaloan.presentation.di.presentationModule
import org.koin.dsl.module

val appModule = module {
    includes(presentationModule)
}