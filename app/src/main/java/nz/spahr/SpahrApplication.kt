package nz.spahr

import android.app.Application
import nz.spahr.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class SpahrApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@SpahrApplication)
            modules(appModule)
        }
    }
}