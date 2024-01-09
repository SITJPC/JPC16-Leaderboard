package th.ac.kmutt.sit.jpc16.leaderboard

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.os.Bundle
import android.view.ViewGroup
import th.ac.kmutt.sit.jpc16.leaderboard.component.data.Decorate
import th.ac.kmutt.sit.jpc16.leaderboard.component.data.LocalDecorate
import th.ac.kmutt.sit.jpc16.leaderboard.component.vendor.BlurSurface
import th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.Leaderboard
import th.ac.kmutt.sit.jpc16.leaderboard.ui.theme.Theme

class LeaderboardActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val decorView = window.decorView
		val rootView = decorView.findViewById(android.R.id.content) as ViewGroup

		setContent {
			CompositionLocalProvider(LocalDecorate provides Decorate(rootView)) {
				Theme {
					Surface(
						modifier = Modifier.fillMaxSize(),
						color = MaterialTheme.colorScheme.background
					) {
						Leaderboard()
					}
				}
			}
		}
	}
}

