package com.example.baseappjetpackcomposeandroidkotlindemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationResponse(
    val name: String?,
    val url: String?
) : Parcelable
