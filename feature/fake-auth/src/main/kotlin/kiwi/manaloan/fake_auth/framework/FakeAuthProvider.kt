package kiwi.manaloan.fake_auth.framework

import kotlinx.coroutines.flow.map
import kiwi.manaloan.auth.entity.AuthState
import kiwi.manaloan.auth.provider.AuthProvider
import kiwi.manaloan.fake_auth.domain.usecase.MonitorSignedInState
import kiwi.manaloan.fake_auth.presentation.sign_in.SignInDestination


class FakeAuthProvider(
    private val monitorSignedInState: MonitorSignedInState
) : AuthProvider {
    override fun getAuthState() = monitorSignedInState().map {
        object : AuthState {
            override val isAuthorized = it
        }
    }

    override fun getAuthDestinationForState(state: AuthState) = SignInDestination::class
}