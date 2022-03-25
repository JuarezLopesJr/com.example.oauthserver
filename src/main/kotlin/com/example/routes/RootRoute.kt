package com.example.routes

import com.example.domain.model.Endpoint
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.rootRoute() {
    get(Endpoint.Root.path) {
        call.respondText("Ktor server working test")
    }
}