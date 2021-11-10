package com.quanticheart.deeplinks.deeplinkDispatcher.extentions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import com.quanticheart.deeplinks.deeplinkDispatcher.DeepLinkDelegate
import com.quanticheart.deeplinks.deeplinkDispatcher.DeepLinkModuleRegistry

@DeepLinkHandler(DeepLinkModule::class)
class DeeplinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val deepLinkDelegate = DeepLinkDelegate(DeepLinkModuleRegistry())
        deepLinkDelegate.dispatchFrom(this)
        finish()
    }
}