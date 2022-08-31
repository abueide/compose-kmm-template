package com.dialexa.mnp.compose.components.shared.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dialexa.mnp.compose.components.Component
import com.dialexa.mnp.compose.theme.AppTheme
import com.dialexa.mnp.toast.ToastType
import org.koin.core.component.KoinComponent

class MainComponent : Component(), KoinComponent {

    @Composable
    override fun view() {
        AppTheme {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                val toast by toastService.currentToast.collectAsState()
                toast?.let {
                    val toastColor = when (it.type) {
                        ToastType.ERROR -> MaterialTheme.colors.error
                        ToastType.SUCCESS -> Color.Green
                        ToastType.WARNING -> Color.Yellow
                        ToastType.DEBUG -> Color.Magenta
                        else -> MaterialTheme.colors.onSurface
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .background(MaterialTheme.colors.surface)
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text("${it.type}: ${it.message}", color = toastColor)
                    }
                }
                navigationService.currentView()
            }
        }
    }
}
