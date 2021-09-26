package com.alex.moviedetail.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

internal data class Genre(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String
): Serializable
