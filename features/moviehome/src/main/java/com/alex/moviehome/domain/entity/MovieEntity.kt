package com.alex.moviehome.domain.entity

internal data class MovieEntity(
    val id: Long,
    val title: String,
    val posterPath: String,
    val votes: Float
)