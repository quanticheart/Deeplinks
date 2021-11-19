package com.quanticheart.deeplinks.deeplinkDispatcher.extentions

import android.os.Bundle
import android.util.Log
import android.webkit.URLUtil
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import com.quanticheart.deeplinks.BuildConfig

@DeepLinkHandler(DeepLinkModule::class)
class DeeplinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            DeepLinkDelegate(DeepLinkModuleRegistry()).dispatchFrom(this)?.let {
                if (!it.isSuccessful) {
                    val url = intent?.data?.toString() ?: ""
//                Patterns.WEB_URL.matcher(intent?.data?.toString() ?: "").matches().toString()
                    if (URLUtil.isValidUrl(url)) {
                        browse(url).start(this)
                    }
                }
            }
        } catch (iae: IllegalArgumentException) {
            if (BuildConfig.DEBUG) {
                Log.e("Deep links", "Invalid URI $iae")
            }
        } finally {
            finish()
        }
    }
}
