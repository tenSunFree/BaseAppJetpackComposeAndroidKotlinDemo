package com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.splash

import androidx.lifecycle.viewModelScope
import com.example.baseappjetpackcomposeandroidkotlindemo.domain.viewstate.IViewEvent
import com.example.baseappjetpackcomposeandroidkotlindemo.domain.viewstate.splash.SplashViewState
import com.example.baseappjetpackcomposeandroidkotlindemo.features.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
) : BaseViewModel<SplashViewState, SplashViewEvent>() {

    init {
        viewModelScope.launch {
            delay(2000)
            setEvent(SplashViewEvent.DirectToDashBoard)
        }
    }

    override fun createInitialState() = SplashViewState()
    override fun onTriggerEvent(event: SplashViewEvent) {}
}

sealed class SplashViewEvent : IViewEvent {
    object DirectToDashBoard : SplashViewEvent()
}