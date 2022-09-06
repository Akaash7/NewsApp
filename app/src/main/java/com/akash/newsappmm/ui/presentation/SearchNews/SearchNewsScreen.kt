package com.akash.newsappmm.ui.presentation.SearchNews

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.akash.newsappmm.common.CustomTab
import com.akash.newsappmm.ui.presentation.Components.NormalNewsItem
import com.akash.newsappmm.ui.presentation.SearchNews.components.HintTextField

@Composable
fun SearchNewsScreen(
    viewModel: SearchNewsViewModel = hiltViewModel()
) {
    val text = viewModel.textState.value.text
    val isHintVisible = viewModel.textState.value.isHintVisible
    
    val list2 = viewModel.listState.value.latestNewsList
    val customTab = CustomTab()
    val ctx = LocalContext.current

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    elevation = 10.dp
                ) {
                    HintTextField(
                        text = text,
                        textStyle = TextStyle(
                            fontSize = 24.sp
                        ),
                        hint = "Search..." ,
                        onValueChange ={
                            viewModel.onEvent(SearchNewsEvent.QueryEntered(it))
                        },
                        onFocusChange = {
                            viewModel.onEvent(SearchNewsEvent.FocusChanged(it))
                        },
                        isHintVisible = isHintVisible
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn(){
                    items(list2){ listItem ->
                        NormalNewsItem(
                            listItem.title,
                            listItem.description,
                            onClick = {
                                customTab.openTab(ctx,listItem.link)
                        })
                    }
                }
            }

        }
    }
