package com.paulo.composestudyyoutube.ui.navigation

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.paulo.composestudyyoutube.ui.navigation.destinations.PostScreenNDestination
import com.paulo.composestudyyoutube.ui.navigation.destinations.ProfileScreenNDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavController
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@SuppressLint("NewApi")
@RequiresApi(Build.VERSION_CODES.O)
@Destination(start = true)
@Composable
fun LoginScreenN(
    navigator: DestinationsNavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login Screen")
        Button(onClick = {
            navigator.navigate(
                ProfileScreenNDestination(
                    User(
                        name = "Paulo Oliveira",
                        id = "userid",
                        created = LocalDateTime.now()
                    )
                )
            )

        }) {
            Text("Go to Profile Screen")
        }
    }
}

@Destination
@SuppressLint("NewApi")
@Composable
fun ProfileScreenN(
    navigator: DestinationsNavController,
    user: User
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Profile Screen: $user", textAlign = TextAlign.Center)
        Button(onClick = {
            navigator.navigate(PostScreenNDestination())
        }) {
            Text("Go to Post Screen")
        }
    }
}

@Destination
@Composable
fun PostScreenN(
    showOnlyPostsByUser: Boolean = false
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Post Screen, $showOnlyPostsByUser")
    }
}