package com.example.stickynotesapp.ui.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.stickynotesapp.data.Note
import kotlin.random.Random


@Composable
fun NotesList(
    notes: List<Note>,
    onDeleteNote: (Note) -> Unit,
    onUpdateNote: (Note) -> Unit
) {
    val stickerColors = listOf(
        Color(0xFFFFE4C4), // bisque
        Color(0xFFF0E68C), // khaki
        Color(0xFFFFD700), // gold
        Color(0xFFADD8E6), // light blue
        Color(0xFF90EE90), // light green
        Color(0xFFFFB6C1), // light pink
        Color(0xFFA52A2A), // brown
        Color(0xFFDEB887), // burly wood
        Color(0xFF5F9EA0), // cadet blue
        Color(0xFF7FFF00), // chartreuse
        Color(0xFFD2691E), // chocolate
        Color(0xFF6495ED), // cornflower blue
        Color(0xFFFF7F50), // coral
        Color(0xFFDC143C), // crimson
        Color(0xFF00FFFF), // cyan
        Color(0xFF00008B)  // dark blue
    )

    fun getRandomColor(): Color {
        return stickerColors[Random.nextInt(stickerColors.size)]
    }
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        itemsIndexed(notes.reversed()) { index, note ->
            val color = stickerColors[index % stickerColors.size]
            NoteItem(
                note = note,
                color = getRandomColor(),
                onDelete = { onDeleteNote(note) },
                onUpdate = { updatedNote -> onUpdateNote(updatedNote) }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
