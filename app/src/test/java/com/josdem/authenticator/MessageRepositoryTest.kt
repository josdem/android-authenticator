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
    fun shouldSendMessage()  {
        val message = "Hello World!"
        every { messageDataSource.sendMessage(message) } returns expectedMessage

        val messageRepository = MessageRepository(messageDataSource)
        val result = messageRepository.sendMessage(message)

        assertEquals(expectedMessage, result)
    }
}
