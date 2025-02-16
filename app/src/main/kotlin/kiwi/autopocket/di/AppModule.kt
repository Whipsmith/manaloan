package kiwi.autopocket.di

import kiwi.autopocket.presentation.di.presentationModule
import org.koin.dsl.module

val appModule = module {
    includes(presentationModule)
}