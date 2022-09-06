package com.akash.newsappmm.ui.presentation.Components

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.akash.newsappmm.common.CustomTab
import com.akash.newsappmm.domain.model.Result
import com.akash.newsappmm.ui.presentation.ListViewState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DynamicListComposable(
    list : List<Result>,
    listState: ListViewState,
    lazylistState : LazyListState,
    ctx : Context
) {
    val customTab = CustomTab()
    when(listState){
        ListViewState.NormalList -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                state = lazylistState
            ){
                items(list){ newsItem ->
                    NormalNewsItem(
                        newsItem.title,
                        newsItem.description,
                        onClick = {
                            customTab.openTab(ctx, uri = newsItem.link)
                        }
                    )
                }
            }
        }
        ListViewState.GridList ->{
            LazyVerticalGrid(

                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(5.dp)),
                cells = GridCells.Fixed(2),
                state = lazylistState,

                content ={
                    items(list){ newsItem ->
                        GridNewsItem(
                            newsItem.title,
                            newsItem.description,
                            onClick = {
                                customTab.openTab(ctx,newsItem.link)
                            }
                        )
                    }
                }
            )
        }
        ListViewState.StaggeredList ->{
            StaggeredGridView(
                results = list,
                onClick = {
                    customTab.openTab(ctx,it.link)
                }
            )
        }
    }
}