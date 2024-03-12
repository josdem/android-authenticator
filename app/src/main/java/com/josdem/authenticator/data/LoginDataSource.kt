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
import com.josdem.authenticator.service.AuthService
import com.josdem.authenticator.service.RetrofitHelper
import java.io.IOException
import java.util.Base64

class LoginDataSource {
    private val oauthService = RetrofitHelper.getInstance().create(AuthService::class.java)

    fun login(
        username: String,
        password: String,
    ): Result<AccessTokenResponse> {
        val authorization =
            Base64.getEncoder().encodeToString("$username:$password".encodeToByteArray())
        Log.d("authorization: ", authorization)
        val call = oauthService.getToken("Basic $authorization", "write", "client_credentials")
        return try {
            val response = call.execute()
            if (response.isSuccessful) {
                return Result.Success(response.body().toString() as AccessTokenResponse)
            } else {
                Result.Error(IOException("Error logging in"))
            }
        } catch (ioe: IOException) {
            Result.Error(IOException("Error logging in", ioe))
        }
    }

    fun logout() {
    }
}
