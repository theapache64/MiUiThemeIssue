package com.example.miuithemeissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miuithemeissue.ui.theme.MiUiThemeIssueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiUiThemeIssueTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        HorizontalGradientSurface(
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Text(text = "Hello World!")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HorizontalGradientSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    backgroundColor: List<Color> = listOf(
        Color(0xFFE1E6F0),
        Color(0xFFE1E6F0),
    ),
    contentColor: Color = Color(0xFF0F1014),
    content: @Composable () -> Unit,
) {

    CompositionLocalProvider(
        LocalContentColor provides contentColor
    ) {
        Box(
            modifier.background(
                brush = Brush.horizontalGradient(backgroundColor),
                shape = shape
            ),
        ) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiUiThemeIssueTheme {
        Greeting("Android")
    }
}