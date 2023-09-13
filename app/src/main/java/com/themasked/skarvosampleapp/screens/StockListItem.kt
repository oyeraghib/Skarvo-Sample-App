package com.themasked.skarvosampleapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.themasked.skarvosampleapp.R

@Composable
fun StockListItem() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(0.7f)
            ) {
                Text(text = "Dow Jones", fontSize = 16.sp)
                Text(text = "Dow Jones Industrial Avg", fontSize = 10.sp)
            }

            Image(
                painter = painterResource(id = R.drawable.stock_down),
                contentDescription = "bedtime icon",
                modifier = Modifier
                    .size(width = 60.dp, height = 40.dp)
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Column(
                modifier = Modifier.weight(0.3f)
            ) {
                Text(
                    text = "$34,333",
                    modifier = Modifier.align(Alignment.End),
                    fontSize = 16.sp
                )

                Text(
                    text = "+32%",
                    modifier = Modifier.align(Alignment.End),
                    fontSize = 10.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFEEEEEE))
        )
    }
}
