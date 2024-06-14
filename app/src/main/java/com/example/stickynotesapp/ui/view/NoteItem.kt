package com.example.stickynotesapp.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.stickynotesapp.data.Note
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun NoteItem(
    note: Note,
    color: Color,
    onDelete: () -> Unit,
    onUpdate: (Note) -> Unit
) {
    var isEditing by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf(TextFieldValue(note.title)) }
    var content by remember { mutableStateOf(TextFieldValue(note.content)) }

    val dateFormat = remember { SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()) }
    val formattedDate = remember(note.timestamp) { dateFormat.format(Date(note.timestamp)) }

    if (isEditing) {
        Card(

            modifier = Modifier .background(color)
                .fillMaxWidth()
                .padding(8.dp)
                ,  shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth()
                )

                TextField(
                    value = content,
                    onValueChange = { content = it },
                    label = { Text("Content") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Button(onClick = {
                        onUpdate(note.copy(title = title.text, content = content.text))
                        isEditing = false
                    }) {
                        Text("Save")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { isEditing = false }) {
                        Text("Cancel")
                    }
                }
            }
        }
    } else {
        Card(

            modifier = Modifier .background(color)
                .fillMaxWidth()
                .padding(8.dp)
                , shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = note.title, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = note.content, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = formattedDate,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    Button(onClick = { isEditing = true }) {
                        Text("Edit")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = onDelete) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}