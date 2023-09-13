package com.themasked.skarvosampleapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockRow(label: String, text: String, onTextChange: (String) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(72.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label, Modifier
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.padding(4.dp))

            TextField(value = text, onValueChange = { newText ->
                onTextChange(newText)
            })
        }
    }
}

@Composable
fun AddNewStockScreen() {
    var stockName by remember {
        mutableStateOf("")
    }

    var companyName by remember {
        mutableStateOf("")
    }

    var stockPrice by remember {
        mutableStateOf("")
    }

    var stockChange by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    )
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        StockRow("Stock Name", stockName) {
            stockName = it
        }
        StockRow("Company Name", companyName) {
            companyName = it
        }
        StockRow("Stock Price", stockPrice) {
            stockPrice = it
        }
        StockRow("Stock Change", stockChange) {
            stockChange = it
        }

    }
}