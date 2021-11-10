package com.quanticheart.deeplinks

import android.app.Application
import android.content.IntentFilter
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import com.quanticheart.deeplinks.deeplinkDispatcher.extentions.DeepLinkDebugReceiver

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initDeepLinkLogger()
    }

    private fun initDeepLinkLogger() {
        val intentFilter = IntentFilter(DeepLinkHandler.ACTION)
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(DeepLinkDebugReceiver(), intentFilter)
    }
}
