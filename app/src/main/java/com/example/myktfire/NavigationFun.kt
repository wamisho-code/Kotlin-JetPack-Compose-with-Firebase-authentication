package com.example.myktfire

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myktfire.pages.HomePage
import com.example.myktfire.pages.LoginPage
import com.example.myktfire.pages.SignUpPage
import com.example.myktfire.viewModel.AuthViewModel

@Composable
fun NavigationFun(modifier: Modifier= Modifier,authViewModel: AuthViewModel){
    val navController= rememberNavController()
    NavHost(navController, startDestination = "login"){
        composable("login"){
            LoginPage(modifier,navController,authViewModel)
        }
        composable("signup"){
            SignUpPage(modifier,navController,authViewModel)
        }
        composable("home"){
            HomePage(modifier,navController,authViewModel)
        }
    }
}