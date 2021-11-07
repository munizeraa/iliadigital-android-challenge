package com.mnzlabz.iliachallenge.data.model

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("name")
    val name: String,

    @SerializedName("city")
    val city: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("conference")
    val conference: String,

    @SerializedName("teamImageUrl")
    val teamImageUrl: String
) {}