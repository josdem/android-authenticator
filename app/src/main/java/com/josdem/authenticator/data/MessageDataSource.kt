/*
Copyright 2024 Jose Morales contact@josdem.io

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
 */

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
