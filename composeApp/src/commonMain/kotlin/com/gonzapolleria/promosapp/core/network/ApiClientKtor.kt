package com.gonzapolleria.promosapp.core.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class ApiClientKtor {
    fun getHttpClient(protocol: URLProtocol, host: String, defaultParams: Map<String, String> = emptyMap() ): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(DefaultRequest) {
                url {
                    this.protocol = protocol
                    this.host = host
                    defaultParams.forEach { (key, value) ->
                        parameters.append(key, value)
                    }
                }
            }

        }
    }
}