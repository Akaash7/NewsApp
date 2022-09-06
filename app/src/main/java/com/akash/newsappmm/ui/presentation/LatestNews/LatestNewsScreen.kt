package com.akash.newsappmm.ui.presentation.LatestNews

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.akash.newsappmm.domain.model.toResult
import com.akash.newsappmm.ui.presentation.Components.DynamicListComposable
import com.akash.newsappmm.ui.presentation.MainScreenViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun LatestNewsScreen(
    latestNewsViewModel: LatestNewsViewModel = hiltViewModel(),
    mainScreenViewModel: MainScreenViewModel,
    padding: PaddingValues
) {
    val resultList = latestNewsViewModel.newsListState.value.latestNewsList.map { it.toResult() }
    val listViewState = mainScreenViewModel.listViewState.value.listViewState
    val lazyListState = rememberLazyListState()
    val ctx = LocalContext.current
    val swipeRefreshState = rememberSwipeRefreshState(false)

    Surface(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = {
                    latestNewsViewModel.getLatestNews()
                }
            ){
               DynamicListComposable(
                   list = resultList,
                   listState = listViewState ,
                   lazylistState = lazyListState,
                   ctx = ctx)
            }
        }
    }
}
