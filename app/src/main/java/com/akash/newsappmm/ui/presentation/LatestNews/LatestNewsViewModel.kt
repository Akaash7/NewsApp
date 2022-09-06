package com.akash.newsappmm.ui.presentation.LatestNews

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akash.newsappmm.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LatestNewsViewModel @Inject constructor(
    private val repositoryImpl: NewsRepository
): ViewModel() {

    private val _newsListState = mutableStateOf(LatestNewsState())
    val newsListState : State<LatestNewsState> = _newsListState

    init {
        getLatestNews()
    }




    fun getLatestNews(){
        viewModelScope.launch {
            val newsList = repositoryImpl.getLatestNewsResult()
            _newsListState.value = newsListState.value.copy(
                latestNewsList = newsList
            )
        }
    }



}