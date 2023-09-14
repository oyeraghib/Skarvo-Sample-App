package com.themasked.skarvosampleapp.screens

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.themasked.skarvosampleapp.R
import com.themasked.skarvosampleapp.models.StockItemModel
import com.themasked.skarvosampleapp.viewmodel.StockItemsViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Preview
@Composable
fun StockList() {
    val stockItemsViewModel: StockItemsViewModel = hiltViewModel()
    val stockItems = stockItemsViewModel.getAllStocks?.observeAsState()

    LazyColumn(content = {
        stockItems?.value?.let { value ->
            items(items = value, key = { stock -> stock.id!! }) { stockItem ->
                val dismissState = rememberDismissState(
                    initialValue = DismissValue.Default,
                    positionalThreshold = {swipeActivationFloat -> swipeActivationFloat/3}
                )
                SwipeToDismiss(
                    modifier = Modifier.animateItemPlacement(),
                    state = dismissState,
                    directions = setOf(DismissDirection.EndToStart),
                    background = {
                      val color by animateColorAsState(
                          when (dismissState.targetValue) {
                              DismissValue.Default -> Color.Transparent
                              DismissValue.DismissedToEnd -> Color.Transparent
                              DismissValue.DismissedToStart -> Color.Red
                          }, label = ""
                      )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color)
                                .padding(10.dp)
                        )
                    },
                    dismissContent = {
                        Box(modifier = Modifier.fillMaxSize()) {
                            StockListItem(
                                stockItemModel = StockItemModel(
                                    stockChange = stockItem.stockChange,
                                    stockName = stockItem.stockName,
                                    stockPrice = stockItem.stockPrice,
                                    companyName = stockItem.companyName
                                )
                            )
                        }
                    },
                )
                if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                    Log.d("Dismissed",   "Dismissed id: ${stockItem.id}")
                    stockItem.id?.let {
                        stockItemsViewModel.deleteStock(it)
                    }
                }
            }
        }
    })
}