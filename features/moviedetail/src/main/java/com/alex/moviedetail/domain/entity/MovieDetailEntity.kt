package com.alex.moviedetail.domain.entity

internal data class MovieDetailEntity(
    val title: String,
    val description: String,
    val backdropPath: String,
    val votes: Float,
    val genres: String
)