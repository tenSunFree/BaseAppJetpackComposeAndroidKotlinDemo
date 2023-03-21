package com.example.baseappjetpackcomposeandroidkotlindemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OriginResponse(
    val name: String?,
    val url: String?,
) : Parcelable