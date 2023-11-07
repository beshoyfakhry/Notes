package com.beshoy.notes.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.beshoy.notes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

    @Query("Select * from Note")
    fun getNotes():Flow<List<Note>>

    @Delete
    suspend fun deleteNote(note:Note)

    @Insert(onConflict = REPLACE)
    suspend fun insertNote(note:Note)

    @Query("Select * from note where id=:id")
    suspend fun getNoteById(id:Int):Note?


}