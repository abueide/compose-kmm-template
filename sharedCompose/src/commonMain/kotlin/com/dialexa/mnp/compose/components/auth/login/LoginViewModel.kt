package com.dialexa.mnp.compose.components.auth.login

import com.dialexa.mnp.authentication.IdentityService
import com.dialexa.mnp.compose.components.fan.dashboard.DashboardComponent
import com.dialexa.mnp.compose.navigation.NavigationService
import com.dialexa.mnp.model.LocalUser
import com.dialexa.mnp.toast.ToastService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginViewModel : KoinComponent {
    val identityService: IdentityService by inject()
    val navigationService: NavigationService by inject()
    val toastService: ToastService by inject()

    val testUsername = "mobiletestuser2@example.com"
    val testPass = "Mob1letestuser!"

    val username: MutableStateFlow<String> = MutableStateFlow(testUsername)
    val password: MutableStateFlow<String> = MutableStateFlow(testPass)

    fun login() {
        CoroutineScope(Dispatchers.Default).launch {
            val authResult = identityService.signIn(username.value, password.value)?.AuthenticationResult
            if (authResult == null) toastService.error("Authentication Failed")
            else {
                navigationService.navigate(
                    DashboardComponent(
                        LocalUser(
                            username.value,
                            authResult
                        )
                    )
                )
            }
        }
    }
}
