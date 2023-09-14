package com.themasked.skarvosampleapp.screens

import android.graphics.Color
import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.themasked.skarvosampleapp.R

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
fun AddNewStockScreen(navController: NavController) {
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

        Button(
            modifier = Modifier
                .padding(0.dp, 16.dp),
            colors = ButtonDefaults.buttonColors(androidx.compose.ui.graphics.Color.Red),
            onClick = { /*TODO*/ }) {
                Text(text = "Add Stock")
        }
    }
}