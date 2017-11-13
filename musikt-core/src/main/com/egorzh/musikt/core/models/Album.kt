package com.egorzh.musikt.core.models

/**
 * @author Egor Zhdan
 */
interface Album {
    val artistName: String
    // todo artwork
    val contentRating: String?
    val copyright: String
//    val editorialNotes: String? // todo fix type
    val genreNames: Array<String>
    val isComplete: Boolean
    val isSingle: Boolean
    val name: String
    val recordLabel: String
    val releaseDate: String
    // todo playParams
    val trackCount: Int
    val url: String
}