package com.egorzh.musikt.networking

import com.egorzh.musikt.networking.auth.Credentials
import java.net.URL
import kotlinx.coroutines.experimental.*
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

/**
 * @author Egor Zhdan
 */
internal class RequestTest {
    @Before
    fun setUp() {
        Credentials.teamID = "team"
        Credentials.privateKey = "key"
    }

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