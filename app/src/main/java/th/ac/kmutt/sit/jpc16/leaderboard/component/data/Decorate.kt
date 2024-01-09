package th.ac.kmutt.sit.jpc16.leaderboard.component.data

import androidx.compose.runtime.compositionLocalOf
import android.view.ViewGroup

data class Decorate(var rootView: ViewGroup?)

val LocalDecorate = compositionLocalOf {
	Decorate(rootView = null)
}