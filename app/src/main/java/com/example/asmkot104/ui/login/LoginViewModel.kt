package com.example.asmkot104.ui.login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: AuthRepository = AuthRepository()) : ViewModel() {
    val currentUser = repository.currentUser
    val hasUser: Boolean get() = repository.hasUser()
    var loginUIState by mutableStateOf(LoginUIState())
        private set

    var loginSuccessful by mutableStateOf(false)
        private set

    var signUpSuccessful by mutableStateOf(false)
        private set

    fun onUserNameChange(userName: String) {
        loginUIState = loginUIState.copy(userName = userName)
    }

    fun onPasswordChange(password: String) {
        loginUIState = loginUIState.copy(password = password)
    }

    fun onUserNameChangeSignUp(userName: String) {
        loginUIState = loginUIState.copy(userNameSignUp = userName)
    }

    fun onPasswordChangeSignUp(password: String) {
        loginUIState = loginUIState.copy(passwordSignUp = password)
    }

    fun onConfirmPasswordChangeSignUp(password: String) {
        loginUIState = loginUIState.copy(confirmPasswordSignUp = password)
    }

    private fun validateLoginForm() =
        loginUIState.password.isNotBlank() && loginUIState.userName.isNotBlank()

    private fun validateSignUpForm() =
        loginUIState.userNameSignUp.isNotBlank() && loginUIState.passwordSignUp.isNotBlank() && loginUIState.confirmPasswordSignUp.isNotBlank()

    fun createUser(context: Context) = viewModelScope.launch {
        try {
            if (!validateSignUpForm()) {
                throw IllegalArgumentException("email and password can not empty.")
            }
            loginUIState = loginUIState.copy(isLoading = true)
            if (loginUIState.passwordSignUp != loginUIState.confirmPasswordSignUp) {
                throw IllegalArgumentException("Password do not match ")
            }
            loginUIState = loginUIState.copy(signUpError = null)
            repository.createUser(
                loginUIState.userNameSignUp,
                loginUIState.passwordSignUp
            ) { isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(context, "Sign-up successful ", Toast.LENGTH_LONG).show()
                    loginUIState = loginUIState.copy(isSuccessLogin = true)
                    signUpSuccessful = true
                } else {
                    Toast.makeText(context, "Sign-up failed ", Toast.LENGTH_LONG).show()
                    loginUIState = loginUIState.copy(isSuccessLogin = false)
                    signUpSuccessful = false
                }
            }

        } catch (e: Exception) {
            loginUIState = loginUIState.copy(signUpError = e.localizedMessage)
            e.printStackTrace()
        } finally {
            loginUIState = loginUIState.copy(isLoading = false)
        }
    }

    fun loginUser(context: Context) = viewModelScope.launch {
        try {
            if (!validateLoginForm()) {
                throw IllegalArgumentException("email and password can not be empty.")
            }

            loginUIState = loginUIState.copy(isLoading = true,)
            loginUIState = loginUIState.copy(loginError = null)
            repository.login(loginUIState.userName, loginUIState.password)
            { isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(context, "Login successful ", Toast.LENGTH_LONG).show()
                    loginUIState = loginUIState.copy(isSuccessLogin = true)
                    loginSuccessful = true
                } else {
                    Toast.makeText(context, "Login failed ", Toast.LENGTH_LONG).show()
                    loginUIState = loginUIState.copy(isSuccessLogin = false)
                }
            }

        } catch (e: Exception) {
            loginUIState = loginUIState.copy(signUpError = e.localizedMessage)
            e.printStackTrace()
        } finally {
            loginUIState = loginUIState.copy(isLoading = false)
        }
    }
}

data class LoginUIState(
    val userName: String = "",
    val password: String = "",
    val userNameSignUp: String = "",
    val passwordSignUp: String = "",
    val confirmPasswordSignUp: String = "",
    val isLoading: Boolean = false,
    val isSuccessLogin: Boolean = false,
    val signUpError: String? = null,
    val loginError: String? = null
)