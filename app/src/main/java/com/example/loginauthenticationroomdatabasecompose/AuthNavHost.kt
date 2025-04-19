package com.example.loginauthenticationroomdatabasecompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginauthenticationroomdatabasecompose.screen.ForgotPasswordScreen
import com.example.loginauthenticationroomdatabasecompose.screen.HomeScreen
import com.example.loginauthenticationroomdatabasecompose.screen.LoginScreen
import com.example.loginauthenticationroomdatabasecompose.screen.RegisterScreen

@Composable
fun AuthNavHost(viewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController, viewModel)
        }
        composable("register") {
            RegisterScreen(navController, viewModel)
        }
        composable("forgot") {
            ForgotPasswordScreen(navController, viewModel)
        }
        composable("home") {
            HomeScreen(navController, viewModel)
        }
    }
}
