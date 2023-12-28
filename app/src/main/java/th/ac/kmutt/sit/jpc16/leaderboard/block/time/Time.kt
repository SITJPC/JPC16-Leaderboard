package th.ac.kmutt.sit.jpc16.leaderboard.block.time

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import th.ac.kmutt.sit.jpc16.leaderboard.ui.theme.Theme
import java.util.Timer
import java.util.TimerTask

@Composable
fun Time() {
    var currentTime by remember { mutableStateOf(getDate()) }
    val coroutineScope = rememberCoroutineScope()

    DisposableEffect(Unit) {
        // Create a new timer and task
        val timer = Timer()
        val task = object : TimerTask() {
            override fun run() {
                coroutineScope.launch {
                    currentTime = getDate()
                }
            }
        }

        // Schedule the task
        val currentMillis = System.currentTimeMillis()
        val nextMinuteMillis = currentMillis + 60000 - (currentMillis % 60000)
        timer.scheduleAtFixedRate(task, java.util.Date(nextMinuteMillis), 60000)

        // Cancel the timer when the composable is disposed
        onDispose {
            timer.cancel()
        }
    }

    // Compose
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = currentTime.first,
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontSize = 24.sp
            )
        )
        Text(
            modifier = Modifier.padding(start = 2.dp, bottom = 2.dp),
            text = currentTime.second,
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontSize = 16.sp
            )
        )
    }
}

@Composable
@Preview(showBackground = true, widthDp = 240, heightDp = 120)
fun Preview() {
    Theme {
        Time()
    }
}