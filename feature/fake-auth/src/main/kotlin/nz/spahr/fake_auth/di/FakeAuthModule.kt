package nz.spahr.fake_auth.di

import nz.spahr.auth.provider.AuthProvider
import nz.spahr.fake_auth.domain.repository.AuthRepository
import nz.spahr.fake_auth.domain.usecase.MonitorSignedInState
import nz.spahr.fake_auth.domain.usecase.SignIn
import nz.spahr.fake_auth.framework.FakeAuthProvider
import nz.spahr.fake_auth.navigation.FakeAuthNavigationGraph
import nz.spahr.fake_auth.presentation.sign_in.SignInViewModel
import nz.spahr.feature.navigation.FeatureNavGraph
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val fakeAuthFeatureModule = module {
    single<AuthProvider> { FakeAuthProvider(get()) }

    single<AuthRepository> { AuthRepository() }
    factory<SignIn> { SignIn(get()) }
    factory<MonitorSignedInState> { MonitorSignedInState(get()) }

    viewModel<SignInViewModel> {
        SignInViewModel(
            get(),
        )
    }

    single {
        FakeAuthNavigationGraph()
    } bind FeatureNavGraph::class
}