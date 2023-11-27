package com.beshoy.notes.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DefaultRadioButton(
    text: String,
    selected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier

) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically

    ) {
        RadioButton(
            selected = selected,
            onClick = onSelect,
            colors = RadioButtonDefaults.colors(
                MaterialTheme.colorScheme.primary,
                MaterialTheme.colorScheme.onBackground
            ),
            modifier = Modifier.semantics {
                contentDescription = text
            }
        )
        Spacer(modifier = modifier.width(8.dp))
        Text(text = text, style = MaterialTheme.typography.bodyMedium)

    }

}
@Preview
@Composable
fun showRadioButton()
{
DefaultRadioButton(text = "AScednding", selected = false, onSelect = { /*TODO*/ })
}
