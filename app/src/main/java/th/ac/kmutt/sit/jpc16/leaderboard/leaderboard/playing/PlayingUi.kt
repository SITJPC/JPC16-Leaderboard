package th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.playing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import th.ac.kmutt.sit.jpc16.leaderboard.component.data.LocalDecorate
import th.ac.kmutt.sit.jpc16.leaderboard.component.vendor.BlurSurface

@Composable
fun PlayingUi(track: Track?) {
	if (track == null) {
		Text(
			text = "No track playing"
		)
	} else {
		Row(
			modifier = Modifier
				.padding(horizontal = 12.dp, vertical = 8.dp)
				.background(
					color = Color.White.copy(alpha = 0.6f), shape = MaterialTheme.shapes.medium
				)
		) {
			AsyncImage(
				modifier = Modifier
					.width(48.dp)
					.clip(RoundedCornerShape(4.dp)),
				model = track.albumArtUri,
				contentDescription = "Album Art",
			)
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