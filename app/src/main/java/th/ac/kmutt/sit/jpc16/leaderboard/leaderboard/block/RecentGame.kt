package th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.block

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import th.ac.kmutt.sit.jpc16.leaderboard.component.internal.BlockHeading
import th.ac.kmutt.sit.jpc16.leaderboard.ui.constant.blockBackgroundColor

@Composable
fun RecentGame() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = blockBackgroundColor,
                shape = MaterialTheme.shapes.medium
            )
    ) {
        BlockHeading(text = "Recent Game")
        Text(text = "aaa")
    }
}