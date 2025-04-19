package com.example.loginauthenticationroomdatabasecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.loginauthenticationroomdatabasecompose.ui.theme.LoginAuthenticationRoomDatabaseComposeTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel = AuthViewModel(application)
        setContent {
            LoginAuthenticationRoomDatabaseComposeTheme {
                AuthNavHost(viewModel)
                }
            }
        }
    }