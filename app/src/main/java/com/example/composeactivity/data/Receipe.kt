package com.example.composeactivity.data

import com.google.gson.annotations.SerializedName

data class Receipe(
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("source_url")
    val source_url: String,
    @SerializedName("recipe_id")
    val recipe_id: String,
    @SerializedName("image_url")
    val image_url: String,
    @SerializedName("social_rank")
    val social_rank: Double,
    @SerializedName("publisher_url")
    val publisher_url: String,
)