package com.egorzh.musikt.containers.storages

import com.beust.klaxon.JsonObject
import com.beust.klaxon.string
import com.egorzh.musikt.core.models.EditorialNotes

/**
 * @author Egor Zhdan
 */
class EditorialNotesContainer(override val standard: String, override val short: String) : EditorialNotes {
    @Suppress
    constructor(json: JsonObject) : this(
            json.string("standard") ?: throw IllegalArgumentException(""),
            json.string("short") ?: throw IllegalArgumentException("")
    )
}