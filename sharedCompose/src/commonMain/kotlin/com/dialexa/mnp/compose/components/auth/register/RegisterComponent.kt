package com.dialexa.mnp.compose.components.auth.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.dialexa.mnp.compose.components.Component
import com.dialexa.mnp.compose.shared.RoundedPrimaryButton

class RegisterComponent : Component() {

    val vm = RegisterViewModel()

    @Composable
    override fun view() {
        RegisterScreen()
    }

    @Composable
    fun RegisterScreen() {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp).fillMaxSize()
        ) {
            val username by vm.username.collectAsState()
            val password by vm.password.collectAsState()

            TextField(
                username,
                onValueChange = { vm.username.value = it },
                label = { Text("Email") }
            )
            TextField(
                password,
                onValueChange = { vm.password.value = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation()
            )
            RoundedPrimaryButton(text = "Register", onClick = vm::register)
        }
    }
}
