package com.example.stickynotesapp.data

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class NoteRepository @Inject constructor(private val noteDao: NoteDao) {
  //,  fun getAllNotes(): Flow<List<Note>> = noteDao.getAllNotes()
   val notes: Flow<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) = noteDao.insert(note)

    suspend fun delete(note: Note) = noteDao.delete(note)
}
