package com.akash.newsappmm.data.remote.DTO

import com.akash.newsappmm.domain.model.SourcesResult

data class NewsSourcesResult(
    val category: List<String>,
    val country: List<String>,
    val description: String?,
    val id: String,
    val language: List<String>,
    val name: String,
    val url: String
)

fun NewsSourcesResult.toSourcesResult() : SourcesResult {
    return SourcesResult(
        name = name,
        link = url,
        description = description ?: ""
    )
}