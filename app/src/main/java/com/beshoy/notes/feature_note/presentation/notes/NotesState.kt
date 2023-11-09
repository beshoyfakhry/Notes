package com.beshoy.notes.feature_note.presentation.notes

import com.beshoy.notes.feature_note.domain.model.Note
import com.beshoy.notes.feature_note.domain.util.NoteOrder
import com.beshoy.notes.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSelectionIsVisible: Boolean = false
)
