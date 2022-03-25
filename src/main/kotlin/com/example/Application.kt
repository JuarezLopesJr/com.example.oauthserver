package com.example

import com.example.plugins.configureAuth
import com.example.plugins.configureKoin
import com.example.plugins.configureMonitoring
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import com.example.plugins.configureSession
import io.ktor.server.application.Application

// https://cloud.mongodb.com/v2/623df61ae8a0190f39f85981#clusters
// IEPQYL8lrghIma52 mongodb password
fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureKoin()
    configureAuth()
    configureRouting()
    configureSerialization()
    configureMonitoring()
    configureSession()
}
