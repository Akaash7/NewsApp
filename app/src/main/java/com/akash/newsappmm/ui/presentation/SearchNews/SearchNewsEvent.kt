package com.akash.newsappmm.ui.presentation.SearchNews

import androidx.compose.ui.focus.FocusState

sealed class SearchNewsEvent(){
    data class QueryEntered(val text:String) : SearchNewsEvent()
    data class FocusChanged(val focusState: FocusState) : SearchNewsEvent()
}
