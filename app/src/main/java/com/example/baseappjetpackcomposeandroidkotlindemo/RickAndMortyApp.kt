package com.example.baseappjetpackcomposeandroidkotlindemo

import android.app.Application
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

@Stable
@HiltAndroidApp
class RickAndMortyApp : Application() {

    val isDark = mutableStateOf(false)
}