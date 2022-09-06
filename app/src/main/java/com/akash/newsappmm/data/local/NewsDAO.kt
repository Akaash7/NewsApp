package com.akash.newsappmm.data.local

import androidx.room.*
import com.akash.newsappmm.domain.model.ArchiveResult
import com.akash.newsappmm.domain.model.NewsResult
import com.akash.newsappmm.domain.model.SourcesResult
import dagger.Provides

@Dao
interface NewsDAO {

    //Latest News
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLatestNews(newsResult:List<NewsResult>)

    @Query("SELECT * FROM NewsResult")
    suspend fun getLatestNews() : List<NewsResult>

    @Query("DELETE FROM NewsResult")
    suspend fun deleteLatestNews()

    //Archive News
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArchiveNews(archiveResult: List<ArchiveResult>)

    @Query("SELECT * FROM ArchiveResult")
    suspend fun getArchiveNews() : List<ArchiveResult>

    @Query("DELETE FROM ArchiveResult")
    suspend fun deleteArchiveNews()

   //Sources
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsSources(sourcesResult: List<SourcesResult>)

    @Query("SELECT * FROM SourcesResult")
    suspend fun getNewsSources() : List<SourcesResult>

    @Query("DELETE FROM SourcesResult")
    suspend fun deleteNewsSources()

}