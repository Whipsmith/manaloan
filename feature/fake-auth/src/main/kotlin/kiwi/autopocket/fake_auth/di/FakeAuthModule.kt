package kiwi.autopocket.fake_auth.di

import kiwi.apptly.auth.provider.AuthProvider
import kiwi.autopocket.fake_auth.domain.repository.AuthRepository
import kiwi.autopocket.fake_auth.domain.usecase.MonitorSignedInState
import kiwi.autopocket.fake_auth.domain.usecase.SignIn
import kiwi.autopocket.fake_auth.framework.FakeAuthProvider
import kiwi.autopocket.fake_auth.navigation.FakeAuthNavigationGraph
import kiwi.autopocket.fake_auth.presentation.sign_in.SignInViewModel
import kiwi.apptly.feature.navigation.FeatureNavGraph
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