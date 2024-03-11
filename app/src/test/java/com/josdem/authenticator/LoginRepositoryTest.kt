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

import android.util.Log
import com.josdem.authenticator.data.LoginDataSource
import com.josdem.authenticator.data.LoginRepository
import com.josdem.authenticator.data.Result
import com.josdem.authenticator.data.model.AccessTokenResponse
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LoginRepositoryTest {
    private val username = "josdem"
    private val password = "password"

    @MockK
    private lateinit var dataSource: LoginDataSource

    private val accessTokenResponse = AccessTokenResponse("token", "access", 100, "scope")
    private val result = Result.Success(accessTokenResponse)

    @Before
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun shouldLoginUser() {
        mockkStatic(Log::class)
        every { Log.d(any(), any()) } returns 0
        every { dataSource.login(username, password) } returns result

        var loginRepository = LoginRepository(dataSource)

        val login = loginRepository.login(username, password)

        assertEquals(result, login)
    }
}
