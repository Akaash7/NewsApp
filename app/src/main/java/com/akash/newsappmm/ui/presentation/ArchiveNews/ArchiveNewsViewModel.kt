package com.akash.newsappmm.ui.presentation.ArchiveNews

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akash.newsappmm.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArchiveNewsViewModel @Inject constructor(
    private val repositoryImpl: NewsRepository
): ViewModel() {

    private val _newsListState = mutableStateOf(ArchiveNewsState())
    val newsListState : State<ArchiveNewsState> = _newsListState

    init {
        getArchiveNews()
    }




    fun getArchiveNews(){
        viewModelScope.launch {
            val newsList = repositoryImpl.getArchiveNewsResult()
            _newsListState.value = newsListState.value.copy(
                latestNewsList = newsList
            )
        }
    }


}