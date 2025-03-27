package com.gonzapolleria.promosapp.features.initconfigs.data.remote

import com.gonzapolleria.promosapp.core.network.ApiClientKtor
import com.gonzapolleria.promosapp.features.initconfigs.data.remote.Response.ConfigResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol

class ApiServiceConfigs(apiClientKtor: ApiClientKtor){
    private val api = apiClientKtor.getHttpClient(
        protocol = URLProtocol.HTTPS,
        host = "getmedia-2ylncwodbq-uc.a.run.app",
        defaultParams = emptyMap()
    )

    suspend fun getConfigRemote() : ConfigResponse? {
        return api.get("").body()
    }
}