package th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.playing

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PlayingUi(track: Track?) {
	if (track == null) {
		Text(
			text = "No track playing"
		)
	} else {
		Text(
			text = "Playing " + track.title
		)
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