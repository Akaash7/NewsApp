package com.akash.newsappmm.data.remote

import com.akash.newsappmm.common.Constants.API_KEY
import com.akash.newsappmm.common.CountryCodes.CANADA
import com.akash.newsappmm.common.CountryCodes.FRANCE
import com.akash.newsappmm.common.CountryCodes.HUNGARY
import com.akash.newsappmm.common.CountryCodes.INDIA
import com.akash.newsappmm.data.remote.DTO.ArchiveNewsDTO
import com.akash.newsappmm.data.remote.DTO.LatestNewsDTO
import com.akash.newsappmm.data.remote.DTO.NewsSourcesDTO
import retrofit2.http.GET

import retrofit2.http.Query

interface NewsApi {

    @GET("api/1/news")
    suspend fun getLatestNews(
        @Query("apikey") apiKey:String = API_KEY,
        @Query("country") country:String =" ${INDIA+","+CANADA}"
    ) : LatestNewsDTO

    @GET("api/1/news")
    suspend fun getArchiveNews(
        @Query("apikey") apiKey:String = API_KEY,
        @Query("country") country:String =" ${HUNGARY+","+ FRANCE}"
    ) : ArchiveNewsDTO


    @GET("/api/1/sources")
    suspend fun getNewsSources(
        @Query("apikey") apiKey:String = API_KEY,
        @Query("country") country:String = INDIA
    ) : NewsSourcesDTO
}