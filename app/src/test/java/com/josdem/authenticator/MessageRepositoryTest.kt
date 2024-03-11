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

package com.josdem.authenticator

import com.josdem.authenticator.data.MessageDataSource
import com.josdem.authenticator.data.MessageRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MessageRepositoryTest {
    private val expectedMessage: String = "Yay!"

    @MockK
    private lateinit var messageDataSource: MessageDataSource

    @Before
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun shouldSendMessage() {
        val message = "Hello World!"
        every { messageDataSource.sendMessage(message) } returns expectedMessage

        val messageRepository = MessageRepository(messageDataSource)
        val result = messageRepository.sendMessage(message)

        assertEquals(expectedMessage, result)
    }

    @Test
    fun shouldGetMessage() {
        every { messageDataSource.getMessage() } returns expectedMessage

        val messageRepository = MessageRepository(messageDataSource)
        val result = messageRepository.getMessage()

        assertEquals(expectedMessage, result)
    }
}
