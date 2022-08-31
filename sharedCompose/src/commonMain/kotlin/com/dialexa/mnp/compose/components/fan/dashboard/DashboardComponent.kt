package com.dialexa.mnp.compose.components.fan.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.dialexa.mnp.compose.components.Component
import com.dialexa.mnp.model.LocalUser

class DashboardComponent(val localUser: LocalUser) : Component() {
    @Composable
    override fun view() {
        Column {
            Text("Hello ${localUser.username}")
            Text("Your session token is ${localUser.session.AccessToken}")
        }
    }
}
