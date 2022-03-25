package com.example.plugins

import com.example.domain.model.UserSession
import com.example.utils.SESSION_FILE_PATH
import com.example.utils.USER_SESSION
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.sessions.SessionTransportTransformerEncrypt
import io.ktor.server.sessions.Sessions
import io.ktor.server.sessions.cookie
import io.ktor.server.sessions.directorySessionStorage
import io.ktor.util.hex
import java.io.File

fun Application.configureSession() {
    install(Sessions) {
        val secretEncryptKey = hex("00112233445566778899aabbccddeeff")
        val secretAuthKey = hex("02030405060708090a0b0c")

        cookie<UserSession>(
            name = USER_SESSION,
            storage = directorySessionStorage(File(SESSION_FILE_PATH))
        ) {
//            cookie.secure = true
            transform(SessionTransportTransformerEncrypt(secretEncryptKey, secretAuthKey))
        }
    }
}