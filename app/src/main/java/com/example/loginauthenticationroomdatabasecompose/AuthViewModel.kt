package com.example.loginauthenticationroomdatabasecompose

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginauthenticationroomdatabasecompose.db.AppDatabase
import com.example.loginauthenticationroomdatabasecompose.db.User
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getDatabase(application)
    private val userDao = db.userDao()

    var loginResult by mutableStateOf<String?>(null)
        private set

    var registerSuccess by mutableStateOf<Boolean?>(null)
        private set

    var loginSuccess by mutableStateOf<Boolean?>(null)
        private set

    var registerResult by mutableStateOf<String?>(null)
        private set

    var forgotPasswordResult by mutableStateOf<String?>(null)
        private set

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val user = userDao.login(username, password)
            if (user != null) {
                loginSuccess = true
                loginResult = "Login successful!"
            } else {
                loginSuccess = false
                loginResult = "Invalid username or password"
            }

        }
    }

    fun register(username: String, password: String) {
        viewModelScope.launch {
            val exists = userDao.findUser(username)
            if (exists == null) {
                userDao.insertUser(User(username = username, password = password))
                registerSuccess = true
                registerResult = "Registration successful!"
            } else {
                registerSuccess = false
                registerResult = "User already exists"
            }
            /*registerResult = if (exists == null) {
                userDao.insertUser(User(username, password))
                "Registration successful!"
            } else {
                "User already exists!"
            }*/
        }
    }

    fun resetPassword(username: String, newPassword: String) {
        viewModelScope.launch {
            val user = userDao.findUser(username)
            forgotPasswordResult = if (user != null) {
                userDao.updatePassword(username, newPassword)
                "Password reset successful!"
            } else {
                "User not found!"
            }
        }
    }

    fun logout() {
        loginSuccess = null
        loginResult = null
    }
}
