package com.josdem.authenticator.data

import android.util.Log
import com.josdem.authenticator.data.model.AccessTokenResponse

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {

    // in-memory cache of the loggedInUser object
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

    fun login(username: String, password: String): Result<AccessTokenResponse> {
        // handle login
        val result = dataSource.login(username, password)

        Log.d("credentials: ", username + ":" + password)

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