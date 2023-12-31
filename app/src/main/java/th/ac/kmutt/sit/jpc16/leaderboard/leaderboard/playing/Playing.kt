package th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.playing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.getSystemService
import android.content.ComponentName
import android.media.session.MediaSessionManager
import th.ac.kmutt.sit.jpc16.leaderboard.service.NotificationReceiver

@Composable
fun Playing() {
	// Local context
	val context = LocalContext.current

	// State
	val track = remember { mutableStateOf<Track?>(null) }

	// Media session effect
	DisposableEffect(Unit) {
		// Construct media session manager
		val mediaSessionManager = getSystemService(context, MediaSessionManager::class.java)
		val component = ComponentName(context, NotificationReceiver::class.java)
		val activeSessionCallback = ActiveSessionCallback(track)

		// Register active sessions
		val activeSessions = mediaSessionManager?.getActiveSessions(component)
		activeSessionCallback.register(activeSessions)

		// Add active sessions changed listener
		mediaSessionManager?.addOnActiveSessionsChangedListener(activeSessionCallback, component)

		onDispose {
			// Remove active sessions changed listener
			mediaSessionManager?.removeOnActiveSessionsChangedListener(activeSessionCallback)

			// Unregister active sessions
			val remainingActiveSessions = mediaSessionManager?.getActiveSessions(component)
			activeSessionCallback.unregister(remainingActiveSessions)
		}
	}

	PlayingUi(track = track.component1())
}