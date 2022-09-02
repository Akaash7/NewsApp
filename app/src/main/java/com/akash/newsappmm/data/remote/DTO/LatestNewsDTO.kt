package com.akash.newsappmm.data.remote.DTO

import com.google.gson.annotations.SerializedName

data class LatestNewsDTO(
    val nextPage: Int,
    @SerializedName("results")
    val latestNewsResults: List<LatestNewsResult>,
    val status: String,
    val totalResults: Int
)