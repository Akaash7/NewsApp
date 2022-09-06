package com.akash.newsappmm.ui.presentation.SearchNews

import com.akash.newsappmm.domain.model.NewsResult
import com.akash.newsappmm.ui.presentation.ListViewState

data class SearchNewsState(
    val latestNewsList: List<NewsResult> = emptyList(),
    val listState : ListViewState = ListViewState.NormalList
)