package kiwi.autopocket

import android.app.Application
import kiwi.autopocket.di.appModule
import kiwi.autopocket.di.featureModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class AutoPocketApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AutoPocketApplication)
            modules(listOf(appModule, featureModules))
        }
    }
}