package com.akash.newsappmm.data

import android.util.Log
import androidx.lifecycle.Transformations.map
import com.akash.newsappmm.data.local.NewsDAO
import com.akash.newsappmm.data.remote.DTO.LatestNewsDTO
import com.akash.newsappmm.data.remote.DTO.toArchiveResult
import com.akash.newsappmm.data.remote.DTO.toNewsResult
import com.akash.newsappmm.data.remote.DTO.toSourcesResult
import com.akash.newsappmm.data.remote.NewsApi
import com.akash.newsappmm.domain.model.ArchiveResult
import com.akash.newsappmm.domain.model.NewsResult
import com.akash.newsappmm.domain.model.SourcesResult
import com.akash.newsappmm.domain.repository.NewsRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.xml.transform.Source

class NewsRepositoryImpl(
    private val api : NewsApi,
    private val dao : NewsDAO
) : NewsRepository {


    override suspend fun getLatestNewsResult(): List<NewsResult> {
        try{
            val response = api.getLatestNews()
            val responseList = response.latestNewsResults.map { it.toNewsResult() }
            dao.insertLatestNews(responseList)
        }
        catch (e:HttpException){
            Log.d("Exception","HttpException")
        }
        catch (e:IOException){
            Log.d("Exception","IOException")
        }
        val list = dao.getLatestNews()

        return list
    }


    override suspend fun getArchiveNewsResult(): List<ArchiveResult> {
        try{
            val response = api.getArchiveNews()
            val responseList = response.latestArchiveNewsResults.map { it.toArchiveResult() }
            dao.insertArchiveNews(responseList)
        }
        catch (e:HttpException){
            Log.d("Exception","HttpException")
        }
        catch (e:IOException){
            Log.d("Exception","IOException")
        }
        val list = dao.getArchiveNews()

        return list
    }


    override suspend fun getNewsSources(): List<SourcesResult> {
        try{
            val response = api.getNewsSources()
            val responseList = response.newsSourcesResult.map{it.toSourcesResult()}
            dao.insertNewsSources(responseList)
        }
        catch (e:HttpException){
            Log.d("Exception","HttpException")
        }
        catch (e:IOException){
            Log.d("Exception","IOException")
        }
        val list = dao.getNewsSources()

        return list
    }

    override suspend fun getSearchResult( search :String): List<NewsResult> {
        var list = emptyList<NewsResult>()
        try{
            val response = api.getSearchResult(search = search)
            list = response.latestNewsResults.map{it.toNewsResult()}
        }
        catch (e:HttpException){
            Log.d("Exception","HttpException")
        }
        catch (e:IOException){
            Log.d("Exception","IOException")
        }

        return list
    }


    override suspend fun clearTables() {
        dao.run {
            deleteLatestNews()
            deleteArchiveNews()
            deleteNewsSources()
        }
    }
}