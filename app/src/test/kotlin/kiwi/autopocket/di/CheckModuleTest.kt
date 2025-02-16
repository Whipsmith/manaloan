package kiwi.autopocket.di

import kiwi.apptly.presentation.app.provider.GetFeatureFlagMap
import kiwi.autopocket.auth.provider.AuthProvider
import kiwi.apptly.presentation.app.AppViewModel
import kiwi.apptly.presentation.app.provider.GetDetailNavigationGraphs
import kiwi.apptly.presentation.app.provider.GetMainNavItems
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.verify.definition
import org.koin.test.verify.injectedParameters
import org.koin.test.verify.verify

@OptIn(KoinExperimentalAPI::class)
class CheckModuleTest : KoinTest {
    @Test
    fun checkAllModules() {
        appModule.verify(
            injections = injectedParameters(
                definition<GetFeatureFlagMap>(List::class),
                definition<GetMainNavItems>(List::class),
                definition<GetDetailNavigationGraphs>(List::class),
                definition<AppViewModel>(AuthProvider::class)
            )
        )
        featureModules.verify()
    }
}