package com.josdem.authenticator.data.model

import com.google.gson.annotations.SerializedName

data class AccessTokenResponse(
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("expires_in")
    val expiresIn: Int,
    val scope: String
)
