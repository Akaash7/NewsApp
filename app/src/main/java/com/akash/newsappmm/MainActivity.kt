package com.akash.newsappmm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.akash.newsappmm.ui.presentation.MainScreenScaffold
import com.akash.newsappmm.ui.theme.NewsAppMMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppMMTheme {
                val navController = rememberNavController()
                MainScreenScaffold(navController = navController)

            }
        }
    }
}

