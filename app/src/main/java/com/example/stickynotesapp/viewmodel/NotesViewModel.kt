package com.example.stickynotesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stickynotesapp.data.Note
import com.example.stickynotesapp.data.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

//    val notes: StateFlow<List<Note>> = repository.getAllNotes()
//        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val notes = repository.notes

    fun addNote(title: String, content: String ) {
        val newNote = Note(
            title = title,
            content = content
        )
        viewModelScope.launch {
            repository.insert(newNote)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            repository.insert(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.delete(note)
        }
    }
}
