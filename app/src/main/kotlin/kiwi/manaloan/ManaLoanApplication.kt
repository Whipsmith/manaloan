package kiwi.manaloan

import android.app.Application
import kiwi.manaLoan.di.appModule
import kiwi.manaLoan.di.featureModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ManaLoanApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ManaLoanApplication)
            modules(listOf(appModule, featureModules))
        }
    }
}