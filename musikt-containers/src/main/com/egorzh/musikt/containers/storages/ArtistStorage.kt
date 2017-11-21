package com.egorzh.musikt.containers.storages

import com.beust.klaxon.array
import com.beust.klaxon.string
import com.egorzh.musikt.containers.relations
import com.egorzh.musikt.core.Reference
import com.egorzh.musikt.core.Resource
import com.egorzh.musikt.core.models.*

/**
 * @author Egor Zhdan
 */
class ArtistStorage internal constructor(res: Resource) : Artist {
    override val name = res.attributes.string("name")
            ?: throw IllegalArgumentException("name not found")

    override val genreNames = (res.attributes.array<String>("genreNames")?.value?.toTypedArray()
            ?: throw IllegalArgumentException("genre names not found"))

    override val editorialNotes = res.attributes.string("editorialNotes")

    override val url = res.attributes.string("url")
            ?: throw IllegalArgumentException("url not found")


    override val albums: List<Reference<Album>> = res.relationships.relations("albums", ::AlbumStorage)
            ?: throw IllegalArgumentException("album relations not found")

    override val genres: List<Reference<Genre>>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val musicVideos: List<Reference<MusicVideo>>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val playlists: List<Reference<Playlist>>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}