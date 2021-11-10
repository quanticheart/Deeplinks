package com.quanticheart.deeplinks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.quanticheart.deeplinks.deeplinkDispatcher.verifyDeeplink
import kotlinx.android.synthetic.main.deeplink_main.deeplink

class AbilityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.deeplink_main)

        deeplink.text = "Not Have a deeplink"

        verifyDeeplink { parameters ->
            deeplink.text = parameters.getString("id")
        }
//        intent.extras?.let { parameters ->
//            deeplink.text = parameters.getString("id")
//        }
    }
}