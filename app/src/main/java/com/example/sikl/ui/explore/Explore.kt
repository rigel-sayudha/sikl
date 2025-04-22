package com.example.sikl.ui.explore

import android.os.Parcelable

@kotlinx.android.parcel.Parcelize
data class Explore(
    val imgExp : Int,
    val titleExp : String
): Parcelable
