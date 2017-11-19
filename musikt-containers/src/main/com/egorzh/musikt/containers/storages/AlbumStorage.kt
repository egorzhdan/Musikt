package com.egorzh.musikt.containers.storages

import com.beust.klaxon.*
import com.egorzh.musikt.core.Resource
import com.egorzh.musikt.core.models.*

/**
 * @author Egor Zhdan
 */
class AlbumStorage internal constructor(res: Resource) : Album {
    override val artistName = res.attributes.string("artistName")
            ?: throw IllegalArgumentException("artist name not found")

    override val contentRating = res.attributes.string("contentRating")

    override val copyright = res.attributes.string("copyright")
            ?: throw IllegalArgumentException("copyright not found")

    override val editorialNotes = res.attributes.obj("editorialNotes")?.let(::EditorialNotesContainer)

    override val genreNames = (res.attributes.array<String>("genreNames")?.value?.toTypedArray()
            ?: throw IllegalArgumentException("genre names not found"))

    override val isComplete = res.attributes.boolean("isComplete")
            ?: throw IllegalArgumentException("isComplete not found")

    override val isSingle = res.attributes.boolean("isComplete")
            ?: throw IllegalArgumentException("isSingle not found")

    override val name = res.attributes.string("name")
            ?: throw IllegalArgumentException("name not found")

    override val recordLabel = res.attributes.string("recordLabel")
            ?: throw IllegalArgumentException("recordLabel not found")

    override val releaseDate = res.attributes.string("releaseDate")
            ?: throw IllegalArgumentException("releaseDate not found")

    override val trackCount = res.attributes.int("trackCount")
            ?: throw IllegalArgumentException("trackCount not found")

    override val url = res.attributes.string("url")
            ?: throw IllegalArgumentException("url not found")

    override val artists: List<Artist>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override val genres: List<Genre>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}