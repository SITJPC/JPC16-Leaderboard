package th.ac.kmutt.sit.jpc16.leaderboard.block.time

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun getDate(): Pair<String, String> {
    val timeFormat = SimpleDateFormat("hh:mm", Locale.getDefault())
    val periodFormat = SimpleDateFormat("a", Locale.getDefault())
    val currentDate = Calendar.getInstance().time
    return Pair(timeFormat.format(currentDate), periodFormat.format(currentDate))
}
