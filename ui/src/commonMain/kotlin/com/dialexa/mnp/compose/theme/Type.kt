package com.dialexa.mnp.compose.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with

val Typography = Typography(
    body1 = TextStyle(
        fontWeight = FontWeight.W300,
        fontSize = 16.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 34.sp
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.W300,
        fontSize = 12.sp
    ),
//    body1 = TextStyle(

//    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
