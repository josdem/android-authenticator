package com.josdem.authenticator.data

import android.util.Log
import com.josdem.authenticator.service.MessageService
import com.josdem.authenticator.service.RetrofitHelper
import com.josdem.authenticator.state.ApplicationState
import java.io.IOException

class MessageDataSource {
    private val messageService = RetrofitHelper.getMessageInstance().create(MessageService::class.java)

    fun sendMessage(message: String): String {
        val call =
            messageService.sendMessage("Bearer " + ApplicationState.getValue("token"), message)
        return try {
            val result = call.execute()
            Log.d("response: ", result.body().toString())
            result.body().toString()
        } catch (ioe: IOException) {
            Log.d("Exception in sending message: ", ioe.message.toString())
            ioe.message.toString()
        }
    }

    fun getMessage(): String {
        val call =
            messageService.getMessage("Bearer " + ApplicationState.getValue("token"))
        return try {
            val result = call.execute()
            Log.d("response: ", result.body().toString())
            result.body().toString()
        } catch (ioe: IOException) {
            Log.d("Exception in sending message: ", ioe.message.toString())
            ioe.message.toString()
        }
    }
}
