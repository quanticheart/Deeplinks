package com.quanticheart.deeplinks.deeplinkDispatcher.extentions

import android.os.Bundle
import android.webkit.URLUtil
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLinkHandler

@DeepLinkHandler(DeepLinkModule::class)
class DeeplinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DeepLinkDelegate(DeepLinkModuleRegistry()).dispatchFrom(this)?.let {
            if (!it.isSuccessful) {
                val url = intent?.data?.toString() ?: ""
//                Patterns.WEB_URL.matcher(intent?.data?.toString() ?: "").matches().toString()
                if (URLUtil.isValidUrl(url)) {
                    browse(url).start(this)
                }
            }
        }
        finish()
    }
}
