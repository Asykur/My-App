package com.example.alotest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageModel(
    val image: String,
    val category : String
): Parcelable