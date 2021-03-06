package com.alex.moviedetail.presentation

internal data class MovieDetailViewState(
    val movieData: MovieView = MovieView()
)

internal data class MovieView(
    val title: String = "",
    val description: String = "",
    val backdropPath: String = "",
    val votes: String = "",
    val genres: List<String> = emptyList(),
    val productionCompaniesView: List<ProductionCompaniesView> = emptyList()
)

internal data class ProductionCompaniesView(
    val name: String,
    val logoPath: String,
)