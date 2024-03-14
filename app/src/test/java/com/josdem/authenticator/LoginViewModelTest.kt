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

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.josdem.authenticator.data.LoginRepository
import com.josdem.authenticator.data.Result
import com.josdem.authenticator.data.model.AccessTokenResponse
import com.josdem.authenticator.ui.login.LoggedInUserView
import com.josdem.authenticator.ui.login.LoginResult
import com.josdem.authenticator.ui.login.LoginViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {
    private val username = "josdem"
    private val password = "12345678"

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @MockK
    private lateinit var loginRepository: LoginRepository

    private val accessTokenResponse = AccessTokenResponse("token", "access", 100, "scope")
    private val result = Result.Success(accessTokenResponse)

    @Before
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun `user should be able to login`() {
        val expectedResult = LoginResult(success = LoggedInUserView(displayName = result.data.accessToken))
        every { loginRepository.login(username, password) } returns result
        val loginViewModel = LoginViewModel(loginRepository)
        loginViewModel.login(username, password)
        assertEquals(expectedResult, loginViewModel.loginResult.value)
    }
}
