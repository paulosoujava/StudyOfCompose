package com.paulo.composestudyyoutube

import android.Manifest
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun showPermission() {
    val permissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA
        )
    )
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner, effect = {
        val observer = LifecycleEventObserver{ _ , event ->
            if(event == Lifecycle.Event.ON_RESUME){
                permissionsState.launchMultiplePermissionRequest()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    } )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        permissionsState.permissions.forEach { perm ->
            when(perm.permission){
                Manifest.permission.CAMERA ->{
                    when{
                        perm.hasPermission ->{
                            Text(text = "Camera permission accepted\n" +
                                    "\n")
                        }
                        perm.shouldShowRationale ->{
                            Text(text = "Require permission to access a camera\n" +
                                    "\n")
                        }
                        perm.isPermanentlyDenied() -> {
                            Text(text = "Camera permission was permanently  denied." +
                                    " You can enable it in the app settings\n" +
                                    "\n")
                        }
                    }
                }
                Manifest.permission.RECORD_AUDIO ->{
                    when{
                        perm.hasPermission ->{
                            Text(text = "RECORD_AUDIO permission accepted\n\n")
                        }
                        perm.shouldShowRationale ->{
                            Text(text = "Require permission to access a RECORD_AUDIO\n" +
                                    "\n")
                        }
                        perm.isPermanentlyDenied() -> {
                            Text(text = "RECORD_AUDIO permission was permanently  denied." +
                                    " You can enable it in the app settings\n" +
                                    "\n")
                        }
                    }
                }
            }
        }



    }
}