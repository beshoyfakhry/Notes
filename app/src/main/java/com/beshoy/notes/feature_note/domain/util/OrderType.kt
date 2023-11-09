package com.beshoy.notes.feature_note.domain.util

sealed class OrderType() {
    object Ascending : OrderType()
    object Descending : OrderType()
}
