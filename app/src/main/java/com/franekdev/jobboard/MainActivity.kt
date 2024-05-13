package com.franekdev.jobboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.franekdev.jobboard.ui.theme.JobBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobBoardTheme {
                MainScreen()
            }
        }
    }
}
