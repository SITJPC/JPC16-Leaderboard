package th.ac.kmutt.sit.jpc16.leaderboard

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import android.os.Bundle
import th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.Leaderboard
import th.ac.kmutt.sit.jpc16.leaderboard.ui.theme.Theme

class LeaderboardActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			Theme {
				Surface(
					modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
				) {
					Leaderboard()
				}
			}
		}
	}
}

