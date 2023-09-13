package com.themasked.skarvosampleapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.themasked.skarvosampleapp.viewmodel.StockItemsViewModel

@Preview
@Composable
fun StockList() {
    val stockItemsViewModel: StockItemsViewModel = viewModel()
    val stockItems = stockItemsViewModel.stocks.observeAsState()

    LazyColumn(content = {
        stockItems.value?.let { value ->
            items(value) {
                StockListItem(stockItemModel = it)
            }
        }
    })
}