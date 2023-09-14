package com.themasked.skarvosampleapp.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

sealed class ThemeColors(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val text: Color
) {
    object Night: ThemeColors(
        background = Color(0xFF000000),
        surface = Color(0xFF000000),
        primary = Color(0xffffffff),
        text = Color(0xffffffff)
    )

    object Day: ThemeColors(
        background = Color(0xffffffff),
        surface = Color(0xffffffff),
        primary = Color(0xff000000),
        text = Color(0xff000000)
    )

}