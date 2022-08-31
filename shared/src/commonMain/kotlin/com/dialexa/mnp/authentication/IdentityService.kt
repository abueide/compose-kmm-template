package com.dialexa.mnp.authentication

import com.apollographql.apollo3.ApolloClient
import com.dialexa.mnp.apollo.SignUpMutation
import com.dialexa.mnp.apollo.type.UserInput
import com.dialexa.mnp.toast.ToastService
import com.liftric.cognito.idp.IdentityProviderClient
import com.liftric.cognito.idp.core.Result
import com.liftric.cognito.idp.core.SignInResponse
import org.koin.core.component.KoinComponent

class IdentityService(
    val apolloClient: ApolloClient,
    val cognitoClient: IdentityProviderClient,
    val toastService: ToastService
) : KoinComponent {

    suspend fun register(userInput: UserInput): SignUpMutation.Data? {
        val apolloResponse = apolloClient.mutation(SignUpMutation(userInput)).execute()
        apolloResponse.errors?.forEach { toastService.error(it.message) }
        return apolloResponse.data
    }

    suspend fun signIn(username: String, password: String): SignInResponse? {
        return try {
            when (val response = cognitoClient.signIn(username, password).value) {
                is SignInResponse -> response
                is Result.Failure -> throw response.exception
                else -> throw NullResponseException()
            }
        } catch (e: Exception) {
            toastService.error(e.message ?: "Unknown Exception")
            null
        }
    }
}

class NullResponseException : Exception("Null Response Exception")
