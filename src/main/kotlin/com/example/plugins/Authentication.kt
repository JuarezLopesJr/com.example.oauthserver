package com.example.plugins

import com.example.domain.model.Endpoint
import com.example.domain.model.UserSession
import com.example.utils.AUTH_SESSION
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.session
import io.ktor.server.response.respondRedirect

fun Application.configureAuth() {
    install(Authentication) {
        session<UserSession>(name = AUTH_SESSION) {
            validate { userSession ->
                userSession
            }
            challenge {
                call.respondRedirect(Endpoint.Unauthorized.path)
            }
        }
    }
}