package com.josdem.authenticator.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val BASE_URL = " https://auth.josdem.io/"
    private const val RESOURCE_URL = " https://resource.josdem.io/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(),
            ).build()
    }

    fun getMessageInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(RESOURCE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}
