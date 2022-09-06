package com.akash.newsappmm.ui.presentation.ArchiveNews

import androidx.compose.foundation.ExperimentalFoundationApi
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ArchiveNewsScreen(
    archiveNewsViewModel: ArchiveNewsViewModel = hiltViewModel(),
    mainScreenViewModel: MainScreenViewModel,
    paddingValues: PaddingValues
) {
    val resultList = archiveNewsViewModel.newsListState.value.latestNewsList.map { it.toResult() }
    val listViewState = mainScreenViewModel.listViewState.value.listViewState
    val ctx = LocalContext.current
    val lazyListState = rememberLazyListState()

    val swipeRefreshState = rememberSwipeRefreshState(false)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = {
                    archiveNewsViewModel.getArchiveNews()
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