package com.beshoy.notes.feature_note.data.repository

import com.beshoy.notes.feature_note.data.data_source.NoteDao
import com.beshoy.notes.feature_note.domain.model.Note
import com.beshoy.notes.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImp(private val dao: NoteDao) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }


    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }
}