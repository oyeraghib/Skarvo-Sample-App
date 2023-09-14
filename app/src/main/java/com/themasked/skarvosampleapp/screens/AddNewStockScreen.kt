package com.themasked.skarvosampleapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.themasked.skarvosampleapp.R
import com.themasked.skarvosampleapp.database.entity.StockItemEntity
import com.themasked.skarvosampleapp.viewmodel.StockItemsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockRow(label: String, text: String, keyboardType: KeyboardType, onTextChange: (String) -> Unit) {
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
            },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType)
            )
        }
    }
}

@Composable
fun TopBackButton(
    imageResId: Int,
    onClick: () -> Unit,
) {

    Box(
        modifier = Modifier
            .size(64.dp)
            .padding(8.dp)
            .background(androidx.compose.ui.graphics.Color.Red, shape = CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(32.dp)
                .padding(4.dp),
            contentScale = (ContentScale.Fit)
        )
    }
}

@Composable
fun AddNewStockScreen(navController: NavController, context: Context) {
    val stockItemsViewModel: StockItemsViewModel = hiltViewModel()

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

    TopBackButton(
        imageResId = R.drawable.ic_back,
        onClick = {
            navController.popBackStack()
        })

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
        StockRow("Stock Name", stockName, keyboardType = KeyboardType.Text) {
            stockName = it
        }
        StockRow("Company Name", companyName, keyboardType = KeyboardType.Text) {
            companyName = it
        }
        StockRow("Stock Price", stockPrice, KeyboardType.Number) {
            stockPrice = it
        }
        StockRow("Stock Change", stockChange, KeyboardType.Decimal) {
            stockChange = it
        }

        Button(
            modifier = Modifier
                .padding(0.dp, 16.dp),
            colors = ButtonDefaults.buttonColors(androidx.compose.ui.graphics.Color.Red),
            onClick = {
                stockItemsViewModel.addStock(StockItemEntity(
                    stockName = stockName,
                    companyName = companyName,
                    stockPrice = stockPrice.toInt(),
                    stockChange = stockChange.toFloat()
                ))
                if (stockName.isEmpty() || companyName.isEmpty() ||
                    stockChange.isEmpty() || stockPrice.isEmpty()) {
                    Toast.makeText(context, "All fields are required", Toast.LENGTH_LONG).show()
                } else {
                    navController.popBackStack()
                }
            }) {
                Text(text = "Add Stock",
                    )
        }
    }
}