package com.themasked.skarvosampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.themasked.skarvosampleapp.screens.AddNewStockScreen
import com.themasked.skarvosampleapp.screens.StockList
import com.themasked.skarvosampleapp.screens.StockListItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddNewStockScreen()
        }
    }
}