package com.akash.newsappmm.data.remote.DTO

data class NewsSourcesResult(
    val category: List<String>,
    val country: List<String>,
    val description: String,
    val id: String,
    val language: List<String>,
    val name: String,
    val url: String
)