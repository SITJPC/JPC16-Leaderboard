package th.ac.kmutt.sit.jpc16.leaderboard.leaderboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import th.ac.kmutt.sit.jpc16.leaderboard.component.Background
import th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.playing.Playing
import th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.playing.PlayingUi
import th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.playing.PlayingUiPreview
import th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.time.Time
import th.ac.kmutt.sit.jpc16.leaderboard.ui.theme.Theme

@Composable
fun Leaderboard() {
	Background()
	Row(modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp), Arrangement.SpaceBetween){
		Time()
		Playing()
	}
}

@Composable
@Preview(showBackground = true, widthDp = 960, heightDp = 540)
fun LeaderboardPreview() {
	Theme {
		Surface(
			modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
		) {
			Time()
			PlayingUiPreview()
			Surface(
				modifier = Modifier.visualEffectBehind(
					// FIXME: Cannot share a state
//        state = visualEffectState,
					effect = VisualEffect.BlurRenderScript(context, 12f),
					updatePolicy = UpdatePolicy.RealTime,
					downscale = 16f,
					baseColor = Color.Black,
				)
			) {
				Leaderboard()
			}
		}
	}
}
