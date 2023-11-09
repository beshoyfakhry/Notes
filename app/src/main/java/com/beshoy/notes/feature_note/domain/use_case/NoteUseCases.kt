package com.beshoy.notes.feature_note.domain.use_case

/*
* This class is to wrap all the usecases classes in order to inject only one single file to the viewModel.
* I can collect the usecases per usage if I want
* */
data class NoteUseCases(
    val deleteNotesUseCase: DeleteNotesUseCase,
    val getNotesUseCase: GetNotesUseCase,
    val addNotesUseCase: AddNotesUseCase,
    val getNoteUseCase:GetNoteUseCase

)
