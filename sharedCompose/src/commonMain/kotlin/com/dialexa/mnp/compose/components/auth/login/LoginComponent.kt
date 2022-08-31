package com.dialexa.mnp.compose.components.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.dialexa.mnp.compose.components.Component
import com.dialexa.mnp.compose.shared.RoundedPrimaryButton

class LoginComponent : Component() {

    val loginViewModel: LoginViewModel = LoginViewModel()

    @Composable
    override fun view() {
        LoginScreen()
    }

    @Composable
    fun LoginScreen() {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp).fillMaxSize()
        ) {
            val username by loginViewModel.username.collectAsState()
            val password by loginViewModel.password.collectAsState()

            TextField(
                username,
                onValueChange = { loginViewModel.username.value = it },
                label = { Text("Email") }
            )
            TextField(
                password,
                onValueChange = { loginViewModel.password.value = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation()
            )
            RoundedPrimaryButton(text = "Login", onClick = loginViewModel::login)
        }
    }
}
