package com.example.stickynotesapp.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stickynotesapp.data.Note
import com.example.stickynotesapp.viewmodel.NotesViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun NotesApp(viewModel: NotesViewModel = hiltViewModel()) {
    val notes by viewModel.notes.collectAsState(initial = emptyList())


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Sticky Notes",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(8.dp)
        )

        NotesInput(onAddNote = { title, content ->
            viewModel.addNote(
                title = title,
                content = content
            )
        })

        Spacer(modifier = Modifier.height(16.dp))

        NotesList(
            notes = notes,
            onDeleteNote = { viewModel.deleteNote(it) },
            onUpdateNote = { viewModel.updateNote(it) }
        )
        

    }
}

