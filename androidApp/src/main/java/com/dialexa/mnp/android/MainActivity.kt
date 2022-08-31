package com.dialexa.mnp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import com.dialexa.mnp.app.ComposeApp
import com.dialexa.mnp.compose.components.shared.main.MainComponent
import org.koin.core.component.KoinComponent

class MainActivity : ComponentActivity(), KoinComponent {
    val app = ComposeApp()
    val mainComponent = MainComponent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainComponent.view()
        }

        val callback = onBackPressedDispatcher.addCallback(this) {
            app.navigationService.back()
        }

        callback.isEnabled = true
    }
}
