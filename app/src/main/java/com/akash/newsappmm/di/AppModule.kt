package com.akash.newsappmm.di

import android.app.Application
import androidx.room.Room
import com.akash.newsappmm.common.Constants
import com.akash.newsappmm.data.NewsRepositoryImpl
import com.akash.newsappmm.data.local.NewsDatabase
import com.akash.newsappmm.data.remote.NewsApi
import com.akash.newsappmm.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNewsApi():NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsDatabase(app: Application) : NewsDatabase {
        return Room.databaseBuilder(
            app,
            NewsDatabase::class.java,
            "news_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesRepository(
        newsApi:NewsApi,
        newsDatabase: NewsDatabase
    ):NewsRepository {
        return NewsRepositoryImpl(api = newsApi, dao = newsDatabase.dao)
    }


}