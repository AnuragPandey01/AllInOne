package xyz.droidev.allinone.model

import androidx.annotation.DrawableRes

/**
 * Project : All in one.
 * @author PANDEY ANURAG.
 */
data class AppData(
    val name: String,
    @DrawableRes
    val icon: Int,
    val url : String
)