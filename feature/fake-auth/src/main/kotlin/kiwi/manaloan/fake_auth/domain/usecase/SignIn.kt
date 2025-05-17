package kiwi.manaloan.fake_auth.domain.usecase

import kiwi.manaloan.fake_auth.domain.repository.AuthRepository

class SignIn(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(username: String, password: String) {
        authRepository.signIn(username, password)
    }
}