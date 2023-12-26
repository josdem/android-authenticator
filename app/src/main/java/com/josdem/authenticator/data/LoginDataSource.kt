package com.josdem.authenticator.data

import com.josdem.authenticator.data.model.AccessTokenResponse
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<AccessTokenResponse> {
        try {
            // TODO: handle loggedInUser authentication
            val accessTokenResponse = AccessTokenResponse("Bearer", "eyJraWQiOiJiNWI1Mzg2OS0wMjc0LTRiZDYtYjhkMC00NWE1NzY4YjRlMWIiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJjbGllbnQiLCJhdWQiOiJjbGllbnQiLCJuYmYiOjE3MDM2MDY1MTAsInNjb3BlIjpbIndyaXRlIl0sImlzcyI6Imh0dHBzOlwvXC9hdXRoLmpvc2RlbS5pb1wvIiwiZXhwIjoxNzAzNjA2ODEwLCJpYXQiOjE3MDM2MDY1MTB9.x6f6-rTkeEbWxG2uODrlGc-PphfkzipTYMD4hAtcwKwUPh8vhIuc6XWtKbxRf5dhUZpeEHSFjM4I5ldpI-naz_A0IOfD0ui9W4kS14o-RGTNv37TsUVihpIwvt4yzvrjah5L3nXrKJf6Qz74b7NqELYuNWAHJwmJOitE7e3GVEqOADcwX7qOGH1UL_S5M1Q6BrOjeTfcMTkGJMkt4a-55cYQSVZlX0gX38Wr7JMXaQryqit8v_2mm8Q6xPICLepsT5GR29U15FXFuR3BFj1JzNiWMKB_M7G9AKsCxQbwEB76I_QRttmwNepTbA6TntAXW1BntUhRScxrUjYQBUczqw", 299, "write")
            return Result.Success(accessTokenResponse)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}