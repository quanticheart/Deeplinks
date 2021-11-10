package com.quanticheart.deeplinks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.quanticheart.deeplinks.deeplinkDispatcher.contants.HOST
import com.quanticheart.deeplinks.deeplinkDispatcher.contants.SCHEME
import com.quanticheart.deeplinks.extentions.notify
import com.quanticheart.deeplinks.extentions.notifyByID
import kotlinx.android.synthetic.main.activity_main.btnNotification1
import kotlinx.android.synthetic.main.activity_main.btnNotification2
import kotlinx.android.synthetic.main.activity_main.btnNotification3
import kotlinx.android.synthetic.main.activity_main.btnNotification4

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNotification1.setOnClickListener {
            val uri = "$SCHEME://$HOST/ability-test"
            notify(
                "ability-test",
                uri,
                uri
            )
        }

        btnNotification2.setOnClickListener {
            val uri = "$SCHEME://$HOST/pokemon-magikarp"
            notify(
                "pokemon-magikarp",
                uri,
                uri
            )
        }

        btnNotification3.setOnClickListener {
            val uri = "$SCHEME://$HOST"
            notify(
                "Home",
                uri,
                uri
            )
        }

        btnNotification4.setOnClickListener {
            val uri = "pokemon-magikarp"
            notifyByID(
                "pokemon-magikarp",
                uri,
                uri
            )
        }
    }
}