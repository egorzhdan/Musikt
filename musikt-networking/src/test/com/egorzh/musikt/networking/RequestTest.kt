package com.egorzh.musikt.networking

import java.net.URL
import org.junit.Test
import org.junit.Assert.*
import kotlinx.coroutines.experimental.*

/**
 * @author Egor Zhdan
 */
internal class RequestTest {
    @Test(timeout = 5000)
    fun sendOK() {
        val req = Request(URL("http://httpbin.org/status/200"))
        runBlocking {
            val resp = req.send()
            assertEquals(resp, "")
        }
    }

    @Test(expected = RequestException::class, timeout = 5000)
    fun sendThrows404() {
        val req = Request(URL("http://httpbin.org/status/404"))
        runBlocking {
            req.send()
        }
    }

    @Test(expected = RequestException::class, timeout = 5000)
    fun sendThrows500() {
        val req = Request(URL("http://httpbin.org/status/500"))
        runBlocking {
            req.send()
        }
    }
}