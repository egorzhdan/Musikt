package com.egorzh.musikt.containers.api

import com.egorzh.musikt.core.models.Artist
import com.egorzh.musikt.containers.storages.ArtistStorage
import com.egorzh.musikt.networking.RequestFactory
import com.egorzh.musikt.networking.Requests

/**
 * @author Egor Zhdan
 */
suspend fun AppleMusic.getArtist(id: String, factory: RequestFactory = Requests.defaultFactory): Artist? =
        Requests.artist(id, factory).handle()?.makeResource()?.let(::ArtistStorage)

suspend fun AppleMusic.getArtists(ids: Iterable<String>, factory: RequestFactory = Requests.defaultFactory): List<Artist>? =
        Requests.artists(ids, factory).handleMultiple()?.map { ArtistStorage(it.makeResource()) }