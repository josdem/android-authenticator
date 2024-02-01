package com.josdem.authenticator.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.josdem.authenticator.data.LoginRepository
import com.josdem.authenticator.data.Result

import com.josdem.authenticator.R

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = loginForm

    private val mutableLiveData = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = mutableLiveData

    fun login(username: String, password: String) {
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {
            mutableLiveData.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.accessToken))
        } else {
            mutableLiveData.value = LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}