package com.akash.newsappmm.ui.presentation.NewsSources

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.akash.newsappmm.domain.model.toResult
import com.akash.newsappmm.ui.presentation.Components.DynamicListComposable
import com.akash.newsappmm.ui.presentation.MainScreenViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun NewsSourcesScreen(
    newsSourcesViewModel: NewsSourcesViewModel = hiltViewModel(),
    mainScreenViewModel: MainScreenViewModel,
    paddingValues: PaddingValues
) {
    val resultList = newsSourcesViewModel.newsListState.value.latestNewsList.map { it.toResult() }
    val listViewState = mainScreenViewModel.listViewState.value.listViewState
    val ctx = LocalContext.current
    val lazyListState = rememberLazyListState()
    val swipeRefreshState = rememberSwipeRefreshState(false)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = paddingValues.calculateTopPadding())
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = {
                    newsSourcesViewModel.getNewsSource()
                }
            ){
               DynamicListComposable(
                   list = resultList,
                   listState = listViewState,
                   lazylistState = lazyListState,
                   ctx = ctx )
            }
        }
    }
}