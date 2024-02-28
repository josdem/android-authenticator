package com.josdem.authenticator.data.model

import java.time.LocalDate

data class Message(
    val message: String,
    val user: User,
    val createdAt: LocalDate,
)
