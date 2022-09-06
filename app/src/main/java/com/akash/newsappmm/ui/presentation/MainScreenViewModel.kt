package com.akash.newsappmm.ui.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
):ViewModel() {
    private val _listViewState = mutableStateOf(MainScreenState())
    val listViewState : State<MainScreenState> = _listViewState


    fun setListViewState(listViewState: ListViewState){
        _listViewState.value = this.listViewState.value.copy(
            listViewState = listViewState
        )
    }
}