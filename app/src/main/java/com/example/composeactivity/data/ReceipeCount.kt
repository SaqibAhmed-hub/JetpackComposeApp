package com.example.composeactivity.data

import com.google.gson.annotations.SerializedName

data class ReceipeCount(
    @SerializedName("count")
    val count: Int,
    @SerializedName("recipes")
    val receipes: List<Receipe>
)