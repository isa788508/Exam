package com.example.projectwork.core.model.top_headline


import com.google.gson.annotations.SerializedName

data class TopHeadline(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: List<BannerResult>,
    @SerializedName("total_pages")
    val totalPages: Int, // 168
    @SerializedName("total_results")
    val totalResults: Int // 3342
)