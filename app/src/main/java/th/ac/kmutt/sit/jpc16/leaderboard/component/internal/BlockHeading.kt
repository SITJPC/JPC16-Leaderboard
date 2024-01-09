package th.ac.kmutt.sit.jpc16.leaderboard.component.internal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import th.ac.kmutt.sit.jpc16.leaderboard.ui.constant.blockBackgroundColor

@Composable
fun BlockHeading(text: String) {
    Column(
        modifier = Modifier
            .background(
                color = blockBackgroundColor,
                shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
            )
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}