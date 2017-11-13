package com.egorzh.musikt.containers.api

import com.egorzh.musikt.networking.Request
import com.egorzh.musikt.networking.RequestFactory
import java.io.InputStream

/**
 * @author Egor Zhdan
 */
fun mockRequest(staticResult: String): RequestFactory {
    return {
        object : Request("") {
            override suspend fun stream(): InputStream {
                return staticResult.byteInputStream()
            }
        }
    }
}