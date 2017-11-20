package com.egorzh.musikt.core

/**
 * @author Egor Zhdan
 */
interface Reference<out T> {
    val id: String

    suspend fun fetch(): T?
}