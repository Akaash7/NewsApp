package com.akash.newsappmm.ui.presentation.NewsSources

import com.akash.newsappmm.domain.model.SourcesResult

data class NewsSourceState(
    val latestNewsList: List<SourcesResult> = emptyList()
)