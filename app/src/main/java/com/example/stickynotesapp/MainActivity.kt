package com.example.stickynotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.stickynotesapp.ui.theme.StickyNotesAppTheme
import com.example.stickynotesapp.ui.view.NotesApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StickyNotesAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    NotesApp()
                }
            }
        }
    }
}
