package nz.spahr.auth.provider

import kotlinx.coroutines.flow.Flow
import nz.spahr.auth.entity.AuthState
import kotlin.reflect.KClass


interface AuthProvider {
    fun getAuthState(): Flow<AuthState>
    fun getAuthDestinationForState(state: AuthState): KClass<*>
}