package com.example.baseappjetpackcomposeandroidkotlindemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterResponse(
    val info: InfoResponse,
    val results: List<Result>
) : Parcelable