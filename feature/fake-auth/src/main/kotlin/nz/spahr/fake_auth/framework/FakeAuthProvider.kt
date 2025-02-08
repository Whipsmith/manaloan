package nz.spahr.fake_auth.framework

import kotlinx.coroutines.flow.map
import nz.spahr.auth.entity.AuthState
import nz.spahr.auth.provider.AuthProvider
import nz.spahr.fake_auth.domain.usecase.MonitorSignedInState
import nz.spahr.fake_auth.presentation.sign_in.SignInDestination


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