package com.example.plugins

import com.example.di.koinModule
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationCallPipeline
import io.ktor.server.application.ApplicationPlugin
import io.ktor.server.application.install
import io.ktor.util.AttributeKey
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext.startKoin

fun Application.configureKoin() {
    install(CustomKoinPlugin) {
        modules(koinModule)
    }
}

internal class CustomKoinPlugin(internal val koinApplication: KoinApplication) {
    // Implements ApplicationPlugin as a companion object.
    companion object Plugin : ApplicationPlugin<ApplicationCallPipeline, KoinApplication, CustomKoinPlugin> {
        // Creates a unique key for the plugin.
        override val key = AttributeKey<CustomKoinPlugin>("CustomKoinPlugin")

        // Code to execute when installing the plugin.
        override fun install(
            pipeline: ApplicationCallPipeline,
            configure: KoinApplication.() -> Unit
        ): CustomKoinPlugin {
            val koinApplication = startKoin(appDeclaration = configure)
            return CustomKoinPlugin(koinApplication)
        }
    }
}