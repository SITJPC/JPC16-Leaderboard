package th.ac.kmutt.sit.jpc16.leaderboard

import java.util.concurrent.locks.ReentrantLock
import androidx.activity.ComponentActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnticipateInterpolator
import th.ac.kmutt.sit.jpc16.leaderboard.func.buildNotificationServiceAlertDialog
import th.ac.kmutt.sit.jpc16.leaderboard.func.isNotificationServiceEnabled

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.main_activity)
		installSplashScreen()
	}

	override fun onResume() {
		super.onResume()

		// New conditional startup thread
		Thread {
			// Check for notification access
			val lock = ReentrantLock()
			if (!isNotificationServiceEnabled(this)) {
				lock.lock()
				Handler(Looper.getMainLooper()).post {
					buildNotificationServiceAlertDialog(this).show()
				}
			}

			// Check unlocked all conditional startup and start leaderboard activity
			if (!lock.isLocked) {
				Intent(this, LeaderboardActivity::class.java).also {
					startActivity(it)
				}
				finish()
			}
		}.start()
	}
}
