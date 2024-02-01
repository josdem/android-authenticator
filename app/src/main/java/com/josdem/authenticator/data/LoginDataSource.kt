package com.josdem.authenticator.data

import android.util.Log
import com.josdem.authenticator.data.model.AccessTokenResponse
import com.josdem.authenticator.service.AuthService
import com.josdem.authenticator.service.RetrofitHelper
import java.io.IOException
import java.util.Base64

class LoginDataSource {

    val oauthService = RetrofitHelper.getInstance().create(AuthService::class.java)


    fun login(username: String, password: String): Result<AccessTokenResponse> {
        val authorization =
            Base64.getEncoder().encodeToString("$username:$password".encodeToByteArray())
        Log.d("authorization: ", authorization)
        val call = oauthService.getToken("Basic $authorization", "write", "client_credentials")
        return try {
            val result = call.execute()
            Log.d("response: ", result.body().toString())
            Result.Success(result.body() as AccessTokenResponse)
        } catch (ioe: IOException) {
            Result.Error(IOException("Error logging in", ioe))
        }
    }

    fun logout() {
    }
}