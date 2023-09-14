package com.themasked.skarvosampleapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.themasked.skarvosampleapp.R


@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Row(
            Modifier.fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Stock App",
                fontSize = 24.sp,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_add), contentDescription = "Add icon",
                Modifier.size(48.dp)
                    .clickable {
                        navController.navigate("add_stock")
                    },
            )
        }

        StockList()
    }
}