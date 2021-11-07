package com.mnzlabz.iliachallenge.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    val name: String,

    @SerializedName("age")
    val age: String,

    @SerializedName("gender")
    val gender: String
) {}