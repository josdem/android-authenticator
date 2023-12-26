package com.josdem.authenticator.service

import com.josdem.authenticator.data.model.AccessTokenResponse
import retrofit2.Response
import retrofit2.http.POST

interface AuthService {

    @POST("oauth2/token")
    suspend fun getToken(): Response<AccessTokenResponse>

}