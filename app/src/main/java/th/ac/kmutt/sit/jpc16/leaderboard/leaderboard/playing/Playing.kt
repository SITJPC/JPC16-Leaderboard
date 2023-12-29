package th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.playing

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.getSystemService
import android.content.ComponentName
import android.media.session.MediaSessionManager
import android.util.Log
import th.ac.kmutt.sit.jpc16.leaderboard.service.NotificationReceiver

@Composable
fun Playing() {
	val context = LocalContext.current
	LaunchedEffect(Unit) {
		val m = getSystemService(context, MediaSessionManager::class.java)
		val component = ComponentName(context, NotificationReceiver::class.java)
		val sessions = m?.getActiveSessions(component)
		Log.d("Sessions", "count: ${sessions?.size}")
		sessions?.forEach {
			Log.d("Sessions", "$it -- " + (it?.metadata?.keySet()?.joinToString()))
			it?.metadata?.keySet()?.forEach { ita ->
				Log.d("Sessions", "$ita: ${ita?.let { it1 -> it.metadata?.getString(it1) }}")
			}
		}
	}

	Text(
		text = "Playing"
	)
}