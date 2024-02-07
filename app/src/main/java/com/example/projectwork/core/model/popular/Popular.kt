package com.example.projectwork.core.model.popular


import com.google.gson.annotations.SerializedName

data class Popular(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: List<OtherResult>,
    @SerializedName("total_pages")
    val totalPages: Int, // 42646
    @SerializedName("total_results")
    val totalResults: Int // 852918
)