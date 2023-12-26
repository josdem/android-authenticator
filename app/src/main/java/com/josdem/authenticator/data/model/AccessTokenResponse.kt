package com.josdem.authenticator.data.model

data class AccessTokenResponse(
    val tokenType: String,
    val accessToken: String,
    val expiresIn: Int,
    val scope: String
)
