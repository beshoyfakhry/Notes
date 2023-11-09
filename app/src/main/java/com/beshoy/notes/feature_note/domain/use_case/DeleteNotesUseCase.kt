package com.beshoy.notes.feature_note.domain.use_case

import com.beshoy.notes.feature_note.domain.model.Note
import com.beshoy.notes.feature_note.domain.repository.NoteRepository

class DeleteNotesUseCase(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}