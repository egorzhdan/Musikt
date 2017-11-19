package com.egorzh.musikt.containers.api

import kotlinx.coroutines.experimental.runBlocking
import java.io.File
import org.junit.Assert.*
import org.junit.Test

/**
 * @author Egor Zhdan
 */
class AlbumsTest {

    private fun mock(id: String) = mockRequest(File("src/test/resources/albums-$id.json").readText())

    @Test
    fun getAlbum() = runBlocking {
        val id = "310730204"
        val a = AppleMusic.getAlbum(id, mock(id))
        assertNotNull(a)
        if (a == null) return@runBlocking

        assertEquals("Bruce Springsteen", a.artistName)
        assertEquals("Born to Run", a.name)
        assertEquals("Springsteen's third album was the one that broke it all open for him.", a.editorialNotes?.short)
        assertArrayEquals(arrayOf("Rock", "Music", "Arena Rock", "Rock & Roll", "Pop", "Pop/Rock"), a.genreNames)
        assertEquals("https://itunes.apple.com/us/album/born-to-run/310730204", a.url)
    }

    @Test
    fun getAlbums() = runBlocking {
        val ids = arrayOf("310730204", "190758914")
        val a = AppleMusic.getAlbums(ids.asIterable(), mock(ids.joinToString(",")))
        assertNotNull(a)
        if (a == null) return@runBlocking
        assertEquals(2, a.size)

        val a1 = a.first()
        val a2 = a.last()

        assertEquals("Bruce Springsteen", a1.artistName)
        assertEquals("Bob Dylan", a2.artistName)
        assertEquals("Born to Run", a1.name)
        assertEquals("The Freewheelin' Bob Dylan", a2.name)
        assertEquals("https://itunes.apple.com/us/album/born-to-run/310730204", a1.url)
        assertEquals("https://itunes.apple.com/us/album/the-freewheelin-bob-dylan/190758914", a2.url)
    }

}