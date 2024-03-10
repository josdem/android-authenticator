package com.josdem.authenticator.data

class MessageRepository(private val messageDataSource: MessageDataSource) {
    fun sendMessage(message: String): String {
        return messageDataSource.sendMessage(message)
    }

    fun getMessage(): String {
        return messageDataSource.getMessage()
    }
}
