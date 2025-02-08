package nz.spahr.fake_auth.domain.usecase

import nz.spahr.fake_auth.domain.repository.AuthRepository

class MonitorSignedInState(
    private val authRepository: AuthRepository
) {
    operator fun invoke() = authRepository.monitorAuth()
}