package com.egorzh.musikt.core.models

/**
 * @author Egor Zhdan
 */
interface Artist {
    val name: String
    val genreNames: Array<String>
    val editorialNotes: String?
    val url: String

    val albums: List<Album>
    val genres: List<Genre>
    val musicVideos: List<MusicVideo>
    val playlists: List<Playlist>
}