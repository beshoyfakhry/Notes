package com.beshoy.notes.feature_note.domain.model

import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.beshoy.notes.ui.theme.Purple40

@Entity
data class Note(
    val tittle: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey
    val id: Int

) {
    companion object {

        val noteColors = listOf(Blue, Red, Purple40)
    }

}
