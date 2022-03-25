package com.example.plugins

import com.example.domain.repository.UserDataSource
import com.example.routes.authorizedRoute
import com.example.routes.deleteUserRoute
import com.example.routes.getUserInfoRoute
import com.example.routes.rootRoute
import com.example.routes.signOutRoute
import com.example.routes.tokenVerificationRoute
import com.example.routes.unauthorizedRoute
import com.example.routes.updateUserInfoRoute
import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import org.koin.java.KoinJavaComponent.inject

fun Application.configureRouting() {

    routing {
        val userDataSource: UserDataSource by inject(UserDataSource::class.java)

        rootRoute()
        tokenVerificationRoute(application, userDataSource)
        authorizedRoute()
        getUserInfoRoute(application, userDataSource)
        updateUserInfoRoute(application, userDataSource)
        deleteUserRoute(application, userDataSource)
        signOutRoute()
        unauthorizedRoute()
    }
}
