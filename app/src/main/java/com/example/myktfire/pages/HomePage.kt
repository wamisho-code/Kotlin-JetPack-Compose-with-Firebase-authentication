package com.example.myktfire.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myktfire.viewModel.AuthState
import com.example.myktfire.viewModel.AuthViewModel

@Composable
fun  HomePage(modifier: Modifier,navController: NavController,authViewModel: AuthViewModel) {
    val authState = authViewModel.authState.observeAsState()
    LaunchedEffect(authState.value) {
        if(authState.value is AuthState.Unauthenticated)
            navController.navigate("login")
    }
    Column(modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Home Page")
        Spacer(modifier= Modifier.height(10.dp))
        Button(
            onClick = {
                authViewModel.signOut()
            }
        ) {
            Text("Logout")
        }

    }
}