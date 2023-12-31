package th.ac.kmutt.sit.jpc16.leaderboard.leaderboard.playing

import androidx.compose.runtime.MutableState
import android.media.MediaMetadata
import android.media.session.MediaController
import android.media.session.MediaSessionManager.OnActiveSessionsChangedListener
import android.util.Log

const val TAG = "Leaderboard/PlayingManager"

class ActiveSessionCallback(trackState: MutableState<Track?>) : OnActiveSessionsChangedListener {
	private val mediaControllerCallback = MediaControllerCallback(trackState)

	override fun onActiveSessionsChanged(controllers: MutableList<MediaController>?) {
		Log.d(TAG, "onActiveSessionsChanged")
		register(controllers)
	}

	fun register(controllers: MutableList<MediaController>?) {
		controllers?.forEach {
			Log.d(TAG, it.toString())
			it.registerCallback(mediaControllerCallback)
		}
		if (controllers != null && controllers.size > 0) {
			mediaControllerCallback.onMetadataChanged(controllers[0].metadata)
		}
	}

	fun unregister(controllers: MutableList<MediaController>?) {
		controllers?.forEach {
			it.unregisterCallback(mediaControllerCallback)
		}
	}
}

class MediaControllerCallback(private val trackState: MutableState<Track?>) :
	MediaController.Callback() {
	override fun onMetadataChanged(metadata: MediaMetadata?) {
		val track = metadata?.let {
			Track(
				title = it.getString(MediaMetadata.METADATA_KEY_TITLE) ?: "",
				artist = it.getString(MediaMetadata.METADATA_KEY_ARTIST) ?: "",
				album = it.getString(MediaMetadata.METADATA_KEY_ALBUM) ?: "",
				albumArtUri = it.getString(MediaMetadata.METADATA_KEY_ALBUM_ART_URI) ?: ""
			)
		}

		trackState.value = track
	}
}