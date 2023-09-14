package com.themasked.skarvosampleapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.themasked.skarvosampleapp.models.StockItemModel
import com.themasked.skarvosampleapp.viewmodel.StockItemsViewModel

@Preview
@Composable
fun StockList() {
    val stockItemsViewModel: StockItemsViewModel = hiltViewModel()
//    stockItemsViewModel.getAllStocks()
    val stockItems = stockItemsViewModel.getAllStocks?.observeAsState()

    LazyColumn(content = {
        stockItems?.value?.let { value ->
            items(value) {
                StockListItem(stockItemModel = StockItemModel(stockChange = it.stockChange,
                    stockName = it.stockName, stockPrice = it.stockPrice, companyName = it.companyName))
            }
        }
    })
}