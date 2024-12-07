package nz.spahr.di

import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.verify.verify

@OptIn(KoinExperimentalAPI::class)
class CheckModuleTest: KoinTest {
    @Test
    fun checkAllModules(){
        appModule.verify()
        navigationModule.verify()
    }
}