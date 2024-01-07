package com.josdem.authenticator

import android.util.Log
import com.josdem.authenticator.data.LoginDataSource
import com.josdem.authenticator.data.LoginRepository
import com.josdem.authenticator.data.Result
import com.josdem.authenticator.data.model.AccessTokenResponse
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LoginRepositoryTest {

    @MockK
    private lateinit var dataSource: LoginDataSource
    
    private val accessTokenResponse = AccessTokenResponse("token", "access", 100, "scope")
    private val result = Result.Success(accessTokenResponse)

    @Before
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun addition_isCorrect() {
        mockkStatic(Log::class)
        every { Log.d(any(), any()) } returns 0
        every { dataSource.login("josdem", "password") } returns result

        var loginRepository = LoginRepository(dataSource)

        val login = loginRepository.login("josdem", "password")

        assertEquals(result, login)
    }
}