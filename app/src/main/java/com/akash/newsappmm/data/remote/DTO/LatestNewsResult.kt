package com.akash.newsappmm.data.remote.DTO

import com.akash.newsappmm.domain.model.NewsResult

data class LatestNewsResult(
    val category: List<String>,
    val content: String?,
    val country: List<String>,
    val creator: List<String>,
    val description: String?,
    val image_url: String?,
    val keywords: List<String>,
    val language: String,
    val link: String,
    val pubDate: String,
    val source_id: String,
    val title: String,
    val video_url: Any
)

fun LatestNewsResult.toNewsResult() : NewsResult{
    return NewsResult(
        title = title,
        description = description ?: " ",
        content = content ?: " ",
        pubDate = pubDate,
        imgURL = image_url ?: "",
        link = link
    )
}