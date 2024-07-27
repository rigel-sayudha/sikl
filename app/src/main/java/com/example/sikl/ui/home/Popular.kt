package com.example.sikl.ui.home

import android.os.Parcelable

@kotlinx.android.parcel.Parcelize
class Popular(
    val imgPopular : Int,
    val titlePopular : String,
    val descPopular : String,
    ): Parcelable
