package com.akash.newsappmm.ui.presentation.NewsSources

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akash.newsappmm.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsSourcesViewModel @Inject constructor(
    private val repositoryImpl: NewsRepository
): ViewModel() {

    private val _newsListState = mutableStateOf(NewsSourceState())
    val newsListState : State<NewsSourceState> = _newsListState

    init {
        getNewsSource()
    }




    fun getNewsSource(){
        viewModelScope.launch {
            val newsList = repositoryImpl.getNewsSources()
            _newsListState.value = newsListState.value.copy(
                latestNewsList = newsList
            )
        }
    }

}