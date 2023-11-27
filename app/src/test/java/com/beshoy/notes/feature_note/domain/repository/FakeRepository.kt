package com.beshoy.notes.feature_note.domain.repository

import com.beshoy.notes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepository : NoteRepository {

    private var notesList = mutableListOf<Note>()

    override fun getNotes(): Flow<List<Note>> {
        return flow { emit(notesList) }

    }

    override suspend fun deleteNote(note: Note) {
        notesList.remove(note)

    }

    override suspend fun insertNote(note: Note) {
        notesList.add(note)
    }

    override suspend fun getNoteById(id: Int): Note? {
        return notesList.find {
            it.id == id
        }
    }
}