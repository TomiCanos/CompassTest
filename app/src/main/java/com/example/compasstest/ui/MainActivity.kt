package com.example.compasstest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compasstest.ui.theme.CompassTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: CompassViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { MainContent() }
    }

    @Composable
    fun MainContent() {
        val everyTenthCharacterResponse by viewModel.response.collectAsState()

        CompassTestTheme {
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (footer, text) = createRefs()

                Text(
                    text = everyTenthCharacterResponse,
                    modifier = Modifier.constrainAs(text) {
                        top.linkTo(parent.top)
                        bottom.linkTo(footer.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )

                Footer(
                    Modifier
                        .constrainAs(footer) {
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .padding(16.dp)
                )
            }
        }
    }

    @Composable
    fun Footer(modifier: Modifier) {
        Column(modifier) {
            Divider(Modifier.padding(bottom = 16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { viewModel.getEveryTenthCharacter() },
            ) {
                Text("Show every tenth character")
            }
        }
    }
}