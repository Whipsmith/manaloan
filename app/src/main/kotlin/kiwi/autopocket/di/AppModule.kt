package kiwi.autopocket.di

import kiwi.apptly.presentation.di.presentationModule
import org.koin.dsl.module

val appModule = module {
    includes(presentationModule)
}