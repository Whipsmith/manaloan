package kiwi.manaloan.fake_auth.presentation.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kiwi.manaloan.fake_auth.domain.usecase.SignIn

class SignInViewModel(
    private val signIn: SignIn,
) : ViewModel() {
    fun onSignIn(
        username: String,
        password: String,
    ) {
        viewModelScope.launch {
            signIn(username, password)
        }
    }
}