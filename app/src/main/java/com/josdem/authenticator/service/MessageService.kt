package com.josdem.authenticator.service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface MessageService {
    @POST("/message")
    fun sendMessage(
        @Header("Authorization") authorization: String,
        @Body message: String,
    ): Call<String>
}
