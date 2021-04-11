package cz.muni.fi.pv256.hw6.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val title: String,
    val text: String,
) : Parcelable
