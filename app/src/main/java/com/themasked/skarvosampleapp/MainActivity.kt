package com.themasked.skarvosampleapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.themasked.skarvosampleapp.screens.AddNewStockScreen
import com.themasked.skarvosampleapp.screens.HomeScreen
import com.themasked.skarvosampleapp.screens.StockList
import com.themasked.skarvosampleapp.screens.StockListItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            AddNewStockScreen()
            Skarvo(this@MainActivity)
        }
    }
}

@Composable
fun Skarvo(context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_screen") {
        composable(route = "home_screen") {
            HomeScreen(navController)
        }
        composable(route = "add_stock") {
            AddNewStockScreen(navController, context = context)
        }
    }
}