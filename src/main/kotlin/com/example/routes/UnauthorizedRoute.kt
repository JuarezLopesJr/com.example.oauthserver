package com.example.routes

import com.example.domain.model.Endpoint
import com.example.utils.UNAUTHORIZED_MESSAGE
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.unauthorizedRoute() {
    get(Endpoint.Unauthorized.path) {
        call.respond(
            message = UNAUTHORIZED_MESSAGE,
            status = HttpStatusCode.Unauthorized
        )
    }
}