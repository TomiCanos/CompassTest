package com.example.compasstest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compasstest.ui.theme.playCoroutinesButtonText
import com.example.compasstest.ui.theme.restoreDefaultValuesButtonText

@Composable
fun Footer(
    onPlayCoroutinesClicked: () -> Unit = {},
    onRestoreDefaultValuesClicked: () -> Unit = {}
) {
    Column {
        Divider()
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            onClick = onPlayCoroutinesClicked,
        ) {
            Text(playCoroutinesButtonText)
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = onRestoreDefaultValuesClicked,
        ) {
            Text(restoreDefaultValuesButtonText)
        }
    }
}

@Preview
@Composable
fun FooterPreview() {
    Footer()
}