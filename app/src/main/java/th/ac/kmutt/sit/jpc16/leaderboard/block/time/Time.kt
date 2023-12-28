package th.ac.kmutt.sit.jpc16.leaderboard.block.time

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.Timer
import java.util.TimerTask

@Composable
fun Time() {
    var currentDate by remember { mutableStateOf(getDate()) }
    val coroutineScope = rememberCoroutineScope()

    DisposableEffect(Unit) {
        // Create a new timer and task
        val timer = Timer()
        val task = object : TimerTask() {
            override fun run() {
                coroutineScope.launch {
                    currentDate = getDate()
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = currentDate, style = MaterialTheme.typography.bodyLarge)
    }
}

fun getDate(): String {
    val currentDate = Calendar.getInstance().time
    val dateFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
    return dateFormat.format(currentDate)
}
