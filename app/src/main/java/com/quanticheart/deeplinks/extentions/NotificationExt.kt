package com.quanticheart.deeplinks.extentions

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.quanticheart.deeplinks.R

fun Context.notify(title: String, content: String, deeplink: String? = null) =
    NotificationExt(this).createNotify(title, content, deeplink)

fun Context.notifyByID(title: String, content: String, deeplink: String? = null) =
    NotificationExt(this).createNotifyByID(title, content, deeplink)

class NotificationExt(private val appContext: Context) {
    companion object {
        private const val NOTIFICATION_ID = 1
        private const val CHANNEL_ID = "test_channel_id_nomad"
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Test notification"
            val descriptionText = "This is about testing notification feature"
            val id = CHANNEL_ID
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance).apply {
                description = descriptionText
                enableLights(true)
                enableVibration(true)
            }

            val notificationManager: NotificationManager =
                appContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun createNotify(title: String, content: String, deeplink: String?) {
        createChannel()
        val intent =
            if (deeplink == null) {
                val pm: PackageManager = appContext.packageManager
                pm.getLaunchIntentForPackage(appContext.packageName)?.apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
            } else {
                Intent(Intent.ACTION_VIEW, Uri.parse(deeplink)).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
            }

        val pendingIntent: PendingIntent =
            PendingIntent.getActivity(appContext, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val builder = NotificationCompat.Builder(appContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(content)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(appContext)) {
            notify(NOTIFICATION_ID, builder.build())
        }
    }

    fun createNotifyByID(title: String, content: String, deeplink: String?) {
        createChannel()
        createNotify(title, content, "notify://$deeplink")
    }
}
