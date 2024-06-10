package com.example.compasstest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compasstest.ui.theme.CompassTestTheme

@Composable
fun MainContent(firstText: String, onFooterClick: () -> Unit) {
    CompassTestTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            val scrollState = rememberScrollState()

            Text(
                text = firstText,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
                    .verticalScroll(scrollState)
                    .padding(16.dp)
            )

            Footer(onFooterClick)
        }
    }
}

@Preview
@Composable
fun MainContentPreview() {
    MainContent("This is a preview") {}
}