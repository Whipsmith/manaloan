package kiwi.manaloan.fake_auth.domain.usecase

import kiwi.manaloan.fake_auth.domain.repository.AuthRepository

class MonitorSignedInState(
    private val authRepository: AuthRepository
) {
    operator fun invoke() = authRepository.monitorAuth()
}