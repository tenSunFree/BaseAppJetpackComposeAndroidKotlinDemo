package com.example.baseappjetpackcomposeandroidkotlindemo.domain.viewstate.splash

import androidx.compose.runtime.Stable
import com.example.baseappjetpackcomposeandroidkotlindemo.domain.viewstate.IViewState

@Stable
data class SplashViewState(
    val isLoading: Boolean = false
) : IViewState