package com.josdem.authenticator.service

import com.josdem.authenticator.data.model.AccessTokenResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {

    @POST("/oauth2/token")
    @FormUrlEncoded
    suspend fun getToken(
        @Header("Authorization") authorization: String,
        @Field("scope") scope: String,
        @Field("grant_type") grantType: String
    ): Response<AccessTokenResponse>

}