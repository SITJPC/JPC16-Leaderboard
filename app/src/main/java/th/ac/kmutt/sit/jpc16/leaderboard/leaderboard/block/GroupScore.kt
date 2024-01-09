package th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.block

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import th.ac.kmutt.sit.jpc16.leaderboard.component.internal.BlockHeading
import th.ac.kmutt.sit.jpc16.leaderboard.ui.constant.blockBackgroundColor

@Composable
fun GroupScore() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = blockBackgroundColor,
                shape = MaterialTheme.shapes.medium
            )
    ) {
        BlockHeading(text = "Group Score")
        Text(text = "aaa")
    }
}