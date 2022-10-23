package com.dialexa.mnp.compose.components

import androidx.compose.runtime.Composable
import com.dialexa.mnp.compose.navigation.NavigationService
import com.dialexa.mnp.toast.ToastService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class Component : KoinComponent {
    val navigationService: NavigationService by inject()
    val toastService: ToastService by inject()
    @Composable
    abstract fun view()
}
