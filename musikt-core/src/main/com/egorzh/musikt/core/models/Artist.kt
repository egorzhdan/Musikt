package com.egorzh.musikt.core.models

import com.egorzh.musikt.core.Reference

/**
 * @author Egor Zhdan
 */
interface Artist {
    val name: String
    val genreNames: Array<String>
    val editorialNotes: String?
    val url: String

    val albums: List<Reference<Album>>
    val genres: List<Reference<Genre>>
    val musicVideos: List<Reference<MusicVideo>>
    val playlists: List<Reference<Playlist>>
}