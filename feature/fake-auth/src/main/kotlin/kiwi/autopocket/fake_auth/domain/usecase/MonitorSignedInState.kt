package kiwi.autopocket.fake_auth.domain.usecase

import kiwi.autopocket.fake_auth.domain.repository.AuthRepository

class MonitorSignedInState(
    private val authRepository: AuthRepository
) {
    operator fun invoke() = authRepository.monitorAuth()
}