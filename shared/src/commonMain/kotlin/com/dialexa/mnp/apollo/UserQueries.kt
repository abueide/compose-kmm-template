package com.dialexa.mnp.apollo

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class UserQueries: KoinComponent {
    val client: ApolloClient by inject()

    suspend fun getUser(id: Int): ApolloResponse<UserQuery.Data> {
        val response = client.query(UserQuery(id.toString())).execute()
        return response
    }
}
