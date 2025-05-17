package kiwi.manaloan.auth.provider

import kiwi.manaloan.auth.entity.AuthState
import kotlinx.coroutines.flow.Flow
import kotlin.reflect.KClass


interface AuthProvider {
    fun getAuthState(): Flow<AuthState>
    fun getAuthDestinationForState(state: AuthState): KClass<*>
}