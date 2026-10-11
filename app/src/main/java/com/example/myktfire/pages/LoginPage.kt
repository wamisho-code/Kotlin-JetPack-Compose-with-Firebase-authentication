package com.example.myktfire.pages

import android.credentials.GetCredentialException
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.navigation.NavController
import com.example.myktfire.R
import com.example.myktfire.viewModel.AuthState
import com.example.myktfire.viewModel.AuthViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.credentials.CustomCredential
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun LoginPage(modifier: Modifier,navController: NavController,authViewModel: AuthViewModel) {
    val coroutineScope = rememberCoroutineScope()

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var buttonEnabled by remember {
        mutableStateOf(true)
    }
    var showProgressBar by remember {
        mutableStateOf(false)
    }
    val context= LocalContext.current

    val googleOption = GetSignInWithGoogleOption.Builder(
        serverClientId = stringResource(R.string.default_web_client_id)
    ).build()

    val credentialRequest = GetCredentialRequest.Builder()
        .addCredentialOption(googleOption)
        .build()
    val credentialManager=  remember {
        CredentialManager.create(context)
    }





    val authState = authViewModel.authState.observeAsState()
    LaunchedEffect(authState.value) {
        if(authState.value is AuthState.Authenticated){
            navController.navigate("home")
            showProgressBar=false
        }else if (authState.value is AuthState.Error){
            Toast.makeText(context,(authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            showProgressBar=false
        }else if( authState.value is AuthState.Loading)
            showProgressBar=true
    }
    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ))
        Spacer(modifier= Modifier.height(10.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {
                email=it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            label = {
                Text("Email Address")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            }
        )
        Spacer(modifier= Modifier.height(6.dp))

        OutlinedTextField(
            value=password,
            onValueChange = {
                password=it
            },
            label = {
                Text("Password")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )


        )
        Spacer(modifier= Modifier.height(10.dp))
        if(showProgressBar){
            CircularProgressIndicator(
                modifier= Modifier.size(20.dp),
                color = Color.Green
            )
            Spacer(modifier= Modifier.height(10.dp))
        }
        Button(
            onClick = {
                authViewModel.login(email,password)
                buttonEnabled=!buttonEnabled
            },
            enabled = buttonEnabled
        ) {
            Text("Login")
        }
        Spacer(modifier= Modifier.height(5.dp))
        Text(
            modifier= Modifier.clickable(
                onClick = {
                    navController.navigate("signup")
                }
            ),
            text="I don't have account",
            textDecoration = TextDecoration.Underline,
            style = TextStyle(
                fontSize = 16.sp
            ),
            color = Color.Blue
        )
        Spacer(modifier= Modifier.height(10.dp))

        OutlinedButton(
            modifier= Modifier.padding(start = 30.dp, end = 30.dp),
            onClick = {
                coroutineScope.launch {
                    try {
                        val result = credentialManager.getCredential(
                            context = context,
                            request = credentialRequest
                        )

                        val credential = result.credential

                        if (
                            credential is CustomCredential &&
                            credential.type ==
                            GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
                        ) {
                            val googleCredential =
                                GoogleIdTokenCredential.createFrom(credential.data)

                            authViewModel.loginWithGoogle(googleCredential.idToken)
                        } else {
                            Toast.makeText(
                                context,
                                "Unexpected credential type",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } catch (e: GetCredentialException) {
                        Log.e("GoogleSignIn", "Credential request failed", e)

                        Toast.makeText(
                            context,
                            "Google Sign-In failed: ${e.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Icon(
                    modifier= Modifier.size(25.dp),
                    painter = painterResource(R.drawable.google_icon),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(modifier= Modifier.width(10.dp))
                Text("Login with Google")
            }
        }


    }
}