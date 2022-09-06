package com.akash.newsappmm.ui.presentation.Components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.akash.newsappmm.ui.presentation.ListViewState

@Composable
fun TopToolbar(
    onMenuItemClick :(ListViewState) -> Unit,
    onSearchIconClick :() -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        color = MaterialTheme.colors.primary,
        elevation = AppBarDefaults.TopAppBarElevation,
    )  {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.End
        ) {
            Box(modifier = Modifier
                .align(Alignment.Bottom)
                ){
                IconButton(onClick = {
                    onSearchIconClick()
                }) {
                    Icon(Icons.Default.Search, "")
                }
            }
            Box(modifier = Modifier
                .align(Alignment.Bottom)) {
                IconButton(onClick = { showMenu = !showMenu }) {
                    Icon(Icons.Default.MoreVert, "")
                }
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false }) {
                    DropdownMenuItem(onClick = { onMenuItemClick(ListViewState.NormalList) }) {
                        Text(text = "List View")
                    }
                    DropdownMenuItem(onClick = { onMenuItemClick(ListViewState.GridList)}) {
                        Text(text = "Grid View")
                    }
                    DropdownMenuItem(onClick = { onMenuItemClick(ListViewState.StaggeredList) }) {
                        Text(text = "Staggered View")
                    }
                }
            }
        }

    }

}



