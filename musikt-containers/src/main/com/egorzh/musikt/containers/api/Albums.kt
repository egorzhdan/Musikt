package com.egorzh.musikt.containers.api

import com.egorzh.musikt.core.models.Album
import com.egorzh.musikt.containers.*
import com.egorzh.musikt.containers.storages.AlbumStorage
import com.egorzh.musikt.networking.RequestFactory
import com.egorzh.musikt.networking.Requests

suspend fun AppleMusic.getAlbum(id: String, factory: RequestFactory = Requests.defaultFactory): Album? =
        Requests.album(id, factory).handle()?.makeResource()?.let(::AlbumStorage)

suspend fun AppleMusic.getAlbums(ids: Iterable<String>, factory: RequestFactory = Requests.defaultFactory): List<Album>? =
        Requests.artists(ids, factory).handleMultiple()?.map { AlbumStorage(it.makeResource()) }