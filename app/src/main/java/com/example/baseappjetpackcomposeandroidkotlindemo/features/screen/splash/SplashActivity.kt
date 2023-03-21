package com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.splash

import com.example.baseappjetpackcomposeandroidkotlindemo.R
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.baseappjetpackcomposeandroidkotlindemo.features.screen.main.MainActivity
import com.example.baseappjetpackcomposeandroidkotlindemo.utils.Utility.launchActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val viewModel by viewModels<SplashViewModel>()

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            SplashScreen()
        }
        lifecycleScope.launchWhenCreated {
            viewModel.uiEvent.collect {
                when (it) {
                    is SplashViewEvent.DirectToDashBoard -> {
                        startMainActivity()
                        finish()
                    }
                    else -> {}
                }
            }
        }
        initStatusBar()
    }

    private fun initStatusBar() {
        window.decorView.systemUiVisibility = 0
        window.statusBarColor = android.graphics.Color.parseColor("#2E2423")
    }

    @Composable
    fun SplashScreen() {
        Surface(color = Color(0xFF2E2423)) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                val image: Painter = painterResource(id = R.drawable.icon_splash_logo)
                Image(
                    painter = image,
                    contentDescription = "icon_splash_logo",
                    modifier = Modifier
                        .width(90.dp)
                        .height(113.dp)
                )
            }
        }
    }

    private fun startMainActivity() {
        launchActivity(
            packageName = packageName,
            className = MainActivity::class.java.name
        )
    }
}