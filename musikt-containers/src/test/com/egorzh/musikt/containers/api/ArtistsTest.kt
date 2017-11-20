package com.egorzh.musikt.containers.api

import kotlinx.coroutines.experimental.runBlocking
import java.io.File
import org.junit.Assert.*
import org.junit.Test

/**
 * @author Egor Zhdan
 */
class ArtistsTest {

    private fun mock(id: String) = mockRequest(File("src/test/resources/artists-$id.json").readText())

    @Test
    fun getArtist() = runBlocking {
        val id = "178834"
        val a = AppleMusic.getArtist(id, mock(id))
        assertNotNull(a)
        if (a == null) return@runBlocking

        assertEquals("Bruce Springsteen", a.name)
        assertArrayEquals(arrayOf("Rock"), a.genreNames)
        assertEquals("https://itunes.apple.com/us/artist/bruce-springsteen/id178834", a.url)
    }

    @Test
    fun getArtists() = runBlocking {
        val ids = arrayOf("178834", "462006")
        val a = AppleMusic.getArtists(ids.asIterable(), mock(ids.joinToString(",")))
        assertNotNull(a)
        if (a == null) return@runBlocking
        assertEquals(2, a.size)

        val a1 = a.first()
        val a2 = a.last()

        assertEquals("Bruce Springsteen", a1.name)
        assertEquals("Bob Dylan", a2.name)
        assertArrayEquals(arrayOf("Rock"), a1.genreNames)
        assertArrayEquals(arrayOf("Rock"), a2.genreNames)
        assertEquals("https://itunes.apple.com/us/artist/bruce-springsteen/id178834", a1.url)
        assertEquals("https://itunes.apple.com/us/artist/bob-dylan/id462006", a2.url)
    }

    @Test
    fun albums() = runBlocking {
        val id = "178834"
        val a = AppleMusic.getArtist(id, mock(id))
        assertNotNull(a)
        if (a == null) return@runBlocking

        assertEquals(25, a.albums.size)
        assertEquals("1112053294", a.albums.firstOrNull()?.id)
    }

}