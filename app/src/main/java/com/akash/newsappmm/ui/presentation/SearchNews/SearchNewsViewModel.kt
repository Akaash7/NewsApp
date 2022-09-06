package com.akash.newsappmm.ui.presentation.SearchNews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akash.newsappmm.data.NewsRepositoryImpl
import com.akash.newsappmm.domain.model.NewsResult
import com.akash.newsappmm.domain.repository.NewsRepository
import com.akash.newsappmm.ui.presentation.LatestNews.LatestNewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchNewsViewModel @Inject constructor(
    private val repositoryImpl: NewsRepository
) : ViewModel() {

    private val _textState = mutableStateOf(HintTextFieldState())
    val textState: State<HintTextFieldState> = _textState


    private val _listState = mutableStateOf(SearchNewsState())
    val listState: State<SearchNewsState> = _listState


    init {
    }


    fun onEvent(searchNewsEvent : SearchNewsEvent){
        when(searchNewsEvent){
            is SearchNewsEvent.QueryEntered ->{
                _textState.value = textState.value.copy(
                    text = searchNewsEvent.text
                )
                getSearchResult(textState.value.text)
            }
            is SearchNewsEvent.FocusChanged ->{
                _textState.value = textState.value.copy(
                    isHintVisible = !searchNewsEvent.focusState.isFocused &&
                            textState.value.text.isBlank()
                )
            }
        }
    }

    fun getSearchResult(search : String){
        if (search.isNotBlank()){
            viewModelScope.launch {
                val newsList = repositoryImpl.getSearchResult(search)
                _listState.value = listState.value.copy(
                    latestNewsList = newsList
                )
            }
        }
        else{
            _listState.value = listState.value.copy(
                latestNewsList = emptyList()
            )
        }

    }
}