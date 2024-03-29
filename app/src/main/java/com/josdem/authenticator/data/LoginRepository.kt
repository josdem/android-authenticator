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

package com.josdem.authenticator.data

import android.util.Log
import com.josdem.authenticator.data.model.AccessTokenResponse

class LoginRepository(val dataSource: LoginDataSource) {
    var user: AccessTokenResponse? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(
        username: String,
        password: String,
    ): Result<AccessTokenResponse> {
        val result = dataSource.login(username, password)

        Log.d("credentials: ", "$username:$password")

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: AccessTokenResponse) {
        this.user = loggedInUser
        Log.d("logged user: ", loggedInUser.tokenType + ":" + loggedInUser.accessToken)
    }
}
