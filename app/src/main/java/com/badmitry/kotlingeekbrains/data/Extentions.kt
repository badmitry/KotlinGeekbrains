package com.badmitry.kotlingeekbrains.data

import android.content.Context
import androidx.core.content.ContextCompat
import com.badmitry.kotlingeekbrains.R
import com.badmitry.kotlingeekbrains.data.model.Color

fun Color.getColorInt(context: Context): Int =
        ContextCompat.getColor(context, getColorRes())

fun Color.getColorRes(): Int = when (this) {
    Color.WHITE -> R.color.color_white
    Color.VIOLET -> R.color.color_violet
    Color.YELLOW -> R.color.color_yellow
    Color.RED -> R.color.color_red
    Color.PINK -> R.color.color_pink
    Color.GREEN -> R.color.color_green
    Color.BLUE -> R.color.color_blue
}
