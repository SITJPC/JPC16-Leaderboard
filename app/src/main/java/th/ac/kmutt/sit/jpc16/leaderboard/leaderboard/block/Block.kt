package th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.block

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import th.ac.kmutt.sit.jpc16.leaderboard.ui.constant.blockBackgroundColor

@Composable
fun Block() {
    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .padding(bottom = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(end = 16.dp)
                .fillMaxHeight()
                .fillMaxWidth(0.4f)
        ) {
            GroupScore()
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
            ) {
                RecentGame()
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                RecentGame()
            }
        }
    }
}