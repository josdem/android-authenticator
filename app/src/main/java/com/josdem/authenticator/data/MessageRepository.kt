package com.josdem.authenticator.data

class MessageRepository(val messageDataSource: MessageDataSource) {

    fun sendMessage(message: String): String {
        return messageDataSource.sendMessage(message)
    }
}