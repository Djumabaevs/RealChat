package com.djumabaevs.realchat.core.util

interface Paginator<T> {

    suspend fun loadNextItems()
}