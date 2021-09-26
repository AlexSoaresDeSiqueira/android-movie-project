package com.alex.moviedetail.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

internal data class MovieResult(
    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val description: String,

    @SerializedName("backdrop_path")
    val backdropPath: String,

    @SerializedName("vote_average")
    val votes: Float,

    @SerializedName("genres")
    val genres: List<Genre>,

    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompaniesData>
): Serializable

internal data class ProductionCompaniesData(
    @SerializedName("name")
    val name: String,

    @SerializedName("logo_path")
    val logoPath: String,
)