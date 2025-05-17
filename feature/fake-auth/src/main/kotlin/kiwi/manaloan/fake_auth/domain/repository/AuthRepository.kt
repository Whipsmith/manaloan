package kiwi.manaloan.fake_auth.domain.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthRepository {
    private val authState =
        MutableStateFlow(false)

    fun monitorAuth() = authState.asStateFlow()

    suspend fun signIn(username: String, password: String) {
        authState.emit(true)
    }

    suspend fun signOut() {
        authState.emit(false)
    }
}