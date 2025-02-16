package kiwi.autopocket.auth.provider

import kotlinx.coroutines.flow.Flow
import kiwi.autopocket.auth.entity.AuthState
import kotlin.reflect.KClass


interface AuthProvider {
    fun getAuthState(): Flow<AuthState>
    fun getAuthDestinationForState(state: AuthState): KClass<*>
}