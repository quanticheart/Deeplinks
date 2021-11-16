package com.quanticheart.deeplinks.deeplinkDispatcher.extentions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.airbnb.deeplinkdispatch.DeepLink

fun Activity.verifyDeeplink(callback: (parameters: Bundle) -> Unit) {
    if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
        intent.extras?.let { parameters ->
            callback(parameters)
        }
    }
}

fun browse(url: String): Intent {
    val browserIntent = Intent(Intent.ACTION_VIEW)
    browserIntent.setDataAndType(Uri.parse(url), "text/html")
    browserIntent.addCategory(Intent.CATEGORY_BROWSABLE)
    return browserIntent
}

fun Intent.start(context: Context) = context.startActivity(this)