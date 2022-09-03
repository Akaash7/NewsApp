package com.akash.newsappmm.domain.repository

import com.akash.newsappmm.domain.model.ArchiveResult
import com.akash.newsappmm.domain.model.NewsResult
import com.akash.newsappmm.domain.model.SourcesResult

interface NewsRepository {

    suspend fun getLatestNewsResult() : List<NewsResult>
    suspend fun getArchiveNewsResult() : List<ArchiveResult>
    suspend fun getNewsSources() : List<SourcesResult>
    suspend fun clearTables()
}