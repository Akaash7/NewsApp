package com.akash.newsappmm.data.local

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.akash.newsappmm.domain.model.ArchiveResult
import com.akash.newsappmm.domain.model.NewsResult
import com.akash.newsappmm.domain.model.SourcesResult

@Database(
    entities = [
        NewsResult::class,
        SourcesResult::class,
        ArchiveResult::class
               ],
    version = 1
)
abstract class NewsDatabase(): RoomDatabase() {
    abstract val dao : NewsDAO
}