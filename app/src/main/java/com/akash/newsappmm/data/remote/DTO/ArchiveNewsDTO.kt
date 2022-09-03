package com.akash.newsappmm.data.remote.DTO

import com.google.gson.annotations.SerializedName

data class ArchiveNewsDTO(
    val nextPage: Int,
    @SerializedName("results")
    val latestArchiveNewsResults: List<ArchiveNewsResult>,
    val status: String,
    val totalResults: Int
)