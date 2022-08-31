package com.dialexa.mnp.model

import com.liftric.cognito.idp.core.AuthenticationResult

data class LocalUser(
    val username: String,
    val session: AuthenticationResult
)
