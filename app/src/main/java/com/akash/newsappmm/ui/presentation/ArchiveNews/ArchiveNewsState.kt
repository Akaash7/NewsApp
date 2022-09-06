package com.akash.newsappmm.ui.presentation.ArchiveNews

import com.akash.newsappmm.domain.model.ArchiveResult

data class ArchiveNewsState(
    val latestNewsList: List<ArchiveResult> = emptyList()
)