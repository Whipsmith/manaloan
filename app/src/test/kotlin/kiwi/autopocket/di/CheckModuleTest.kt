package kiwi.autopocket.di

import kiwi.autopocket.app.provider.GetFeatureFlagMap
import kiwi.autopocket.auth.provider.AuthProvider
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
                definition<kiwi.autopocket.app.provider.GetMainNavItems>(List::class),
                definition<kiwi.autopocket.app.provider.GetDetailNavigationGraphs>(List::class),
                definition<kiwi.autopocket.app.AppViewModel>(AuthProvider::class)
            )
        )
        featureModules.verify()
    }
}