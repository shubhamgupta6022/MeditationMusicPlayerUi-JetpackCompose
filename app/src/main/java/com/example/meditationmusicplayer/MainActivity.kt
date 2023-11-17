package com.example.meditationmusicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.meditationmusicplayer.ui.HomeScreen
import com.example.meditationmusicplayer.ui.theme.MeditationMusicPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationMusicPlayerTheme {
                HomeScreen()
            }
        }
    }
}
