package com.themasked.skarvosampleapp.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.themasked.skarvosampleapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()

    //for making the bottom sheet reach half of the device's height
    val density = LocalDensity.current
    val screenHeight = with(density) {(LocalConfiguration.current.screenHeightDp).dp}
    val midY = screenHeight / 2

    val bottomSheetScaffoldState = scaffoldState.bottomSheetState.currentValue
    Log.d("Home Screen", "$bottomSheetScaffoldState")

    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Stock App",
                fontSize = 24.sp,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.onPrimary
            )

            Spacer(modifier = Modifier.width(16.dp))

            Image(
                if (isSystemInDarkTheme()) {
                    painterResource(id = R.drawable.ic_add_white)
                } else {
                    painterResource(id = R.drawable.ic_add)
                }, contentDescription = "Add icon",
                Modifier
                    .size(48.dp)
                    .clickable {
                        navController.navigate("add_stock")
                    },
            )
        }

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetContent = {
                Column(
                    modifier = Modifier
                        .height(midY)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Skarvo Sample App",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            },
            sheetPeekHeight = 72.dp,
            content = {
                StockList()
            },
        )
    }
}