package th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.playing

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import th.ac.kmutt.sit.jpc16.leaderboard.ui.constant.blockBackgroundColor
import th.ac.kmutt.sit.jpc16.leaderboard.ui.constant.blockBackgroundColorT2


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlayingUi(track: Track?) {
    if (track == null) {
        Text(
            text = "No track playing"
        )
    } else {
        Row(
            modifier = Modifier
                .background(
                    color = blockBackgroundColorT2, shape = MaterialTheme.shapes.medium
                ),
            Arrangement.Start,
            Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .width(56.dp)
                    .height(56.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .scale(1.2f),
                model = track.albumArtUri,
                contentDescription = "Album Art",
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 2.dp)
                    .width(156.dp), Arrangement.Center
            ) {
                Text(
                    text = track.title,
                    style = MaterialTheme.typography.labelMedium,
                    maxLines = 1,
                    modifier = Modifier.basicMarquee(delayMillis = 3000),
                )
                Text(
                    text = track.artist,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 240, heightDp = 160)
fun PlayingUiPreview() {
    PlayingUi(
        Track(
            "Running Through The Night",
            "Seori",
            "?depacse ohw",
            "https://i.scdn.co/image/ab67616d0000b273ffd2d252ce504dac86a25efc"
        )
    )
}