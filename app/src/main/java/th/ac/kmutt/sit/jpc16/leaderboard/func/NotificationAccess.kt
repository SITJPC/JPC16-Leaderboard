package th.ac.kmutt.sit.jpc16.leaderboard.func

import java.util.concurrent.locks.ReentrantLock
import kotlin.system.exitProcess
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.provider.Settings
import th.ac.kmutt.sit.jpc16.leaderboard.R

fun isNotificationServiceEnabled(context: Context): Boolean {
	return Settings.Secure.getString(context.contentResolver, "enabled_notification_listeners")
		.contains(context.packageName)
}

fun buildNotificationServiceAlertDialog(context: Context): AlertDialog {
	val alertDialogBuilder = AlertDialog.Builder(context)
	alertDialogBuilder.setTitle(R.string.notification_listener_service)
	alertDialogBuilder.setMessage(R.string.notification_listener_service_explanation)
	alertDialogBuilder.setPositiveButton(
		R.string.ok
	) { _, _ ->
		val i = Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
		context.startActivity(i)
		return@setPositiveButton
	}
	alertDialogBuilder.setNegativeButton(
		R.string.cancel
	) { _, _ ->
		exitProcess(0)
	}

	return alertDialogBuilder.create()
}