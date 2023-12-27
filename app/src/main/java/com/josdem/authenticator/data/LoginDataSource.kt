package com.josdem.authenticator.data

import android.util.Log
import com.josdem.authenticator.data.model.AccessTokenResponse
import com.josdem.authenticator.service.AuthService
import com.josdem.authenticator.service.RetrofitHelper
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.io.IOException

class LoginDataSource {

    val oauthService = RetrofitHelper.getInstance().create(AuthService::class.java)


    fun login(username: String, password: String): Result<AccessTokenResponse> {

        MainScope().launch {
            Log.d("calling retrofit", "===========================================================================================>")
            val result = oauthService.getToken("client", "secret", "write", "client_credentials")
            Log.d("response: ", result.body().toString())
        }

        return try {
            val accessTokenResponse = AccessTokenResponse(
                "Bearer",
                "eyJraWQiOiJiNWI1Mzg2OS0wMjc0LTRiZDYtYjhkMC00NWE1NzY4YjRlMWIiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJjbGllbnQiLCJhdWQiOiJjbGllbnQiLCJuYmYiOjE3MDM2MDY1MTAsInNjb3BlIjpbIndyaXRlIl0sImlzcyI6Imh0dHBzOlwvXC9hdXRoLmpvc2RlbS5pb1wvIiwiZXhwIjoxNzAzNjA2ODEwLCJpYXQiOjE3MDM2MDY1MTB9.x6f6-rTkeEbWxG2uODrlGc-PphfkzipTYMD4hAtcwKwUPh8vhIuc6XWtKbxRf5dhUZpeEHSFjM4I5ldpI-naz_A0IOfD0ui9W4kS14o-RGTNv37TsUVihpIwvt4yzvrjah5L3nXrKJf6Qz74b7NqELYuNWAHJwmJOitE7e3GVEqOADcwX7qOGH1UL_S5M1Q6BrOjeTfcMTkGJMkt4a-55cYQSVZlX0gX38Wr7JMXaQryqit8v_2mm8Q6xPICLepsT5GR29U15FXFuR3BFj1JzNiWMKB_M7G9AKsCxQbwEB76I_QRttmwNepTbA6TntAXW1BntUhRScxrUjYQBUczqw",
                299,
                "write"
            )
            Result.Success(accessTokenResponse)
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
    }
}