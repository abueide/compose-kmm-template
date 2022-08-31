package com.dialexa.mnp.compose.components.auth.register

import com.dialexa.mnp.apollo.type.UserInput
import com.dialexa.mnp.authentication.IdentityService
import com.dialexa.mnp.compose.components.auth.login.LoginComponent
import com.dialexa.mnp.compose.navigation.NavigationService
import com.dialexa.mnp.toast.ToastService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RegisterViewModel : KoinComponent {
    val identityService: IdentityService by inject()
    val toastService: ToastService by inject()
    val navigationService: NavigationService by inject()

    val username: MutableStateFlow<String> = MutableStateFlow("")
    val password: MutableStateFlow<String> = MutableStateFlow("")

    fun register() {
        CoroutineScope(Dispatchers.Default).launch {
            val response = identityService.register(
                UserInput(
                    "10/27/1999",
                    email = username.value,
                    "Mobile",
                    "Tester",
                    password.value
                )
            )
            if (response != null) {
                toastService.success("Registration Complete! Please check your email for a verification link.")
                navigationService.navigate(LoginComponent())
            }
        }
    }
}
