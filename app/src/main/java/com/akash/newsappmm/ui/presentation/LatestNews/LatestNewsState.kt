package com.akash.newsappmm.ui.presentation.LatestNews

import com.akash.newsappmm.domain.model.NewsResult

data class LatestNewsState(
    val latestNewsList: List<NewsResult> = emptyList()
)