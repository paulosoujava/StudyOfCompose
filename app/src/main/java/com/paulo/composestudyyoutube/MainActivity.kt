package com.paulo.composestudyyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.ui.Modifier
import com.paulo.composestudyyoutube.ui.components.MyClickableButton
import com.paulo.composestudyyoutube.ui.components.MyEditText
import com.paulo.composestudyyoutube.ui.components.Show

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyEditText()
        }
    }
}

