package com.beshoy.notes.feature_note.domain.use_case

import com.beshoy.notes.feature_note.domain.model.Note
import com.beshoy.notes.feature_note.domain.repository.FakeRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first


import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AddNotesUseCaseTest() {

    lateinit var addNotesUseCase: AddNotesUseCase
    lateinit var noteRepository: FakeRepository


    @Before
    fun setUp() {
        noteRepository = FakeRepository()
        addNotesUseCase = AddNotesUseCase(noteRepository)
    }


    @Test
    fun `note with blank title should throw exception`() = runBlocking {

        val noteToBeAdded = Note("", "content", 5.toLong(), 1)
        try {
            addNotesUseCase(noteToBeAdded)
        } catch (e: Note.InvalidNoteException) {
            assertThat(e).hasMessageThat().contains("Title can not be empty.")
        }

    }

    @Test
    fun `note with blank content should throw exception`() = runBlocking {

        val noteToBeAdded = Note("tittle", "", 5.toLong(), 1)
        try {
            addNotesUseCase(noteToBeAdded)
        } catch (e: Note.InvalidNoteException) {
            assertThat(e).hasMessageThat().contains("Content can not be empty.")
        }
    }


    @Test
    fun `note full data should be added`() = runBlocking {

        val noteToBeAdded = Note("note", "content", 5.toLong(), 1)

        addNotesUseCase(noteToBeAdded)

        val notesList = noteRepository.getNotes().first()
        assertThat(notesList).contains(noteToBeAdded)

    }
}