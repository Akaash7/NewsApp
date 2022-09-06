package com.akash.newsappmm.ui.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.akash.newsappmm.ui.presentation.ArchiveNews.ArchiveNewsScreen
import com.akash.newsappmm.ui.presentation.Components.BottomNavItem
import com.akash.newsappmm.ui.presentation.Components.BottomNavigationBar
import com.akash.newsappmm.ui.presentation.Components.TopToolbar
import com.akash.newsappmm.ui.presentation.LatestNews.LatestNewsScreen
import com.akash.newsappmm.ui.presentation.NewsSources.NewsSourcesScreen
import com.akash.newsappmm.ui.presentation.SearchNews.SearchNewsScreen

@Composable
fun MainScreenScaffold(
    navController : NavHostController,
    mainScreenViewModel: MainScreenViewModel = hiltViewModel(),
) {
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    var showTopBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        "search" -> false
        else -> true
    }

    showTopBar = when (navBackStackEntry?.destination?.route) {
        "search" -> false
        else -> true
    }
    Scaffold(
        topBar = {
            if(showTopBar) {
                TopToolbar(
                    onMenuItemClick = { listViewState ->
                        when (listViewState) {
                            ListViewState.NormalList -> {
                                mainScreenViewModel.setListViewState(listViewState)
                            }
                            ListViewState.GridList -> {
                                mainScreenViewModel.setListViewState(listViewState)
                            }
                            ListViewState.StaggeredList -> {
                                mainScreenViewModel.setListViewState(listViewState)
                            }
                        }
                    },
                    onSearchIconClick = {
                        navController.navigate("search")
                    }
                )
            }
        },
        bottomBar = {
            if(showBottomBar){
                BottomNavigationBar(
                    items = listOf(
                        BottomNavItem(
                            name = "Latest",
                            route = "latest",
                            icon = Icons.Default.Message
                        ),
                        BottomNavItem(
                            name = "Archive",
                            route = "archive",
                            icon = Icons.Default.Message
                        ),
                        BottomNavItem(
                            name = "Sources",
                            route = "sources",
                            icon = Icons.Default.Message
                        )

                    ),
                    navController = navController,
                    onItemClick = { navController.navigate(it.route) })
            }
        }
    ) {
        Navigation(
            navController = navController,
            mainScreenViewModel=mainScreenViewModel,
            padding = it
        )

    }

}
    @Composable
    fun Navigation(
        navController: NavHostController,
        mainScreenViewModel: MainScreenViewModel,
        padding : PaddingValues
    ) {
        NavHost(navController = navController, startDestination = "latest") {
            composable(
                route = "latest"
            ) {
                LatestNewsScreen(mainScreenViewModel = mainScreenViewModel, padding = padding)
            }
            composable("archive") {
                ArchiveNewsScreen(mainScreenViewModel = mainScreenViewModel, paddingValues = padding)
            }
            composable("sources") {
                NewsSourcesScreen(mainScreenViewModel= mainScreenViewModel, paddingValues = padding)
            }
            composable("search") {
                SearchNewsScreen()
            }

        }
    }


