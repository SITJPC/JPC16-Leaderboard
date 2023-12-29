package th.ac.kmutt.sit.jpc16.leaderboard.service

import android.content.Intent
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log


class NotificationReceiver: NotificationListenerService() {
	override fun onNotificationPosted(sbn: StatusBarNotification?) {
		Log.d("NotificationReceiver", "onNotificationPosted")
	}

}