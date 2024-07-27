package com.example.sikl.ui.home

import android.os.Parcelable

@kotlinx.android.parcel.Parcelize
data class Newest(
    val imgNew : Int,
    val titleNew : String,
    val descNew : String
): Parcelable
