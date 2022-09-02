package com.akash.newsappmm.data.remote.DTO

import com.google.gson.annotations.SerializedName

data class NewsSourcesDTO(
    @SerializedName("results")
    val newsSourcesResult: List<NewsSourcesResult>,
    val status: String
)