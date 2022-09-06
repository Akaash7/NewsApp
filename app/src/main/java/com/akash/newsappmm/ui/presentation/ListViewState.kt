package com.akash.newsappmm.ui.presentation

sealed class ListViewState() {
    object NormalList : ListViewState()
    object GridList : ListViewState()
    object StaggeredList : ListViewState()
}