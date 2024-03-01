package com.josdem.authenticator.service

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.Header
import retrofit2.http.POST

interface MessageService {

    @POST("/message")
    fun sendMessage(
        @Header("Authorization") authorization: String,
        @Field("data") scope: String,
    ): Call<String>
}
