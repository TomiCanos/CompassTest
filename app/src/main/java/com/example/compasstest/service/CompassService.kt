package com.example.compasstest.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import javax.inject.Inject

class CompassService @Inject constructor() {
    private val client = HttpClient(OkHttp) {
        defaultRequest { url(BASE_URL) }

        install(Logging) {
            logger = Logger.SIMPLE
        }
    }

    suspend fun getAbout(): String {
        return client.get(ABOUT).body()
    }

    companion object {
        private const val BASE_URL = "https://www.compass.com/"
        private const val ABOUT = "about"

    }
}