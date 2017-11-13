package com.egorzh.musikt.core

import com.beust.klaxon.*

/**
 * @author Egor Zhdan
 */
data class Resource(val id: String, val type: String,
                    val href: String? = null,
                    val attributes: JsonObject = JsonObject(),
                    val relationships: JsonObject = JsonObject(),
                    val meta: JsonObject = JsonObject()) {

    /**
     * Initializes a Resource from a web response
     *
     * @exception IllegalArgumentException if some of the required params is not present or its format is malformed
     */
    constructor(json: JsonObject) : this(
            json.string("id") ?: throw IllegalArgumentException("id not found"),
            json.string("type") ?: throw IllegalArgumentException("type not found"),
            json.string("href") ?: throw IllegalArgumentException("href not found"),
            json.obj("attributes") ?: throw IllegalArgumentException("attributes not found"),
            json.obj("relationships") ?: throw IllegalArgumentException("relationships not found"),
            json.obj("meta") ?: JsonObject()
    )

}