package com.beshoy.notes.feature_note.domain.use_case


import com.beshoy.notes.feature_note.domain.model.Note
import com.beshoy.notes.feature_note.domain.repository.NoteRepository

class AddNotesUseCase(private val repository: NoteRepository) {

    @Throws(Note.InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {

            throw Note.InvalidNoteException("Title can not be empty.")
        }
        if (note.content.isBlank()) {

            throw Note.InvalidNoteException("Content can not be empty.")
        }

        repository.insertNote(note)
    }
}