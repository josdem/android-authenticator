/*
Copyright 2024 Jose Morales contact@josdem.io

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
 */

package com.josdem.authenticator.ui.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josdem.authenticator.R
import com.josdem.authenticator.data.LoginRepository
import com.josdem.authenticator.data.Result

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    private val loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = loginForm

    private val mutableLiveData = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = mutableLiveData

    fun login(
        username: String,
        password: String,
    ) {
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {
            mutableLiveData.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.accessToken))
        } else {
            mutableLiveData.value = LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(
        username: String,
        password: String,
    ) {
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
