package com.beshoy.notes.feature_note.domain.model

import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.beshoy.notes.ui.theme.Purple40

@Entity
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null

) {
    companion object {

        val noteColors = listOf(Blue, Red, Purple40)
    }

    class InvalidNoteException(message: String) : Exception(message)

}
