package com.dialexa.mnp.app

import com.apollographql.apollo3.ApolloClient
import com.dialexa.mnp.authentication.IdentityService
import com.dialexa.mnp.toast.ToastService
import com.liftric.cognito.idp.IdentityProviderClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object MnpApp {

    private val region: String = "us-east-2"
    private val clientId: String = "6kcamhgfhilq4ue31jq02h51s5"
    private val cognitoClient = IdentityProviderClient(region, clientId)
    private val apolloClient: ApolloClient = ApolloClient.Builder().serverUrl("http://10.0.2.2:3000/graphql/").build()

    val appModule = module {
        single { cognitoClient }
        single { apolloClient }
        singleOf(::ToastService)
        singleOf(::IdentityService)
    }
}
