package com.beshoy.notes.di

import android.app.Application
import androidx.room.Room
import com.beshoy.notes.feature_note.data.data_source.NoteDao
import com.beshoy.notes.feature_note.data.data_source.NoteDatabase
import com.beshoy.notes.feature_note.data.repository.NoteRepositoryImp
import com.beshoy.notes.feature_note.domain.repository.NoteRepository
import com.beshoy.notes.feature_note.domain.use_case.AddNotesUseCase
import com.beshoy.notes.feature_note.domain.use_case.DeleteNotesUseCase
import com.beshoy.notes.feature_note.domain.use_case.GetNoteUseCase
import com.beshoy.notes.feature_note.domain.use_case.GetNotesUseCase
import com.beshoy.notes.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(context: Application): NoteDatabase {

        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()

    }


    @Provides
    @Singleton
    fun provideNoteDao(appDatabase: NoteDatabase): NoteDao {
        return appDatabase.noteDao()
    }


    @Provides
    @Singleton
    fun providesNoteRepository(dao: NoteDao): NoteRepository {
        return NoteRepositoryImp(dao)
    }

    @Provides
    @Singleton
    fun provideNotesUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            DeleteNotesUseCase(repository),
            GetNotesUseCase(repository),
            AddNotesUseCase(repository),
            GetNoteUseCase(repository)
        )
    }



}