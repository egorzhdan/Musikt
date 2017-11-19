package com.egorzh.musikt.core.models

/**
 * @author Egor Zhdan
 */
interface Album {
    val artistName: String
    // todo artwork
    val contentRating: String?
    val copyright: String
    val editorialNotes: EditorialNotes?
    val genreNames: Array<String>
    val isComplete: Boolean
    val isSingle: Boolean
    val name: String
    val recordLabel: String
    val releaseDate: String
    // todo playParams
    val trackCount: Int
    val url: String

    val artists: List<Artist>
    val genres: List<Genre>
    // todo list of tracks
}