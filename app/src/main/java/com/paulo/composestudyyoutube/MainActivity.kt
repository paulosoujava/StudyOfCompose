package com.paulo.composestudyyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.paulo.composestudyyoutube.ui.cloneInstagram.ProfileScreen
import com.paulo.composestudyyoutube.ui.components.*
import com.paulo.composestudyyoutube.ui.meditationComponents.HomeScreen
import com.paulo.composestudyyoutube.ui.navigation.NavGraph
import com.paulo.composestudyyoutube.ui.navigation.NavGraphs
import com.paulo.composestudyyoutube.ui.navigation.Navigation
import com.paulo.composestudyyoutube.ui.sizeWindow.ShowSizeWindow
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(color = Color.White) {

                ShowSizeWindow()

            }
        }
    }
}


