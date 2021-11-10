package com.quanticheart.deeplinks.deeplinkDispatcher

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.airbnb.deeplinkdispatch.DeepLink
import com.quanticheart.deeplinks.AbilityActivity
import com.quanticheart.deeplinks.PokemonActivity
import com.quanticheart.deeplinks.deeplinkDispatcher.contants.HOST
import com.quanticheart.deeplinks.deeplinkDispatcher.contants.HOST2
import com.quanticheart.deeplinks.deeplinkDispatcher.contants.SCHEME
import com.quanticheart.deeplinks.deeplinkDispatcher.contants.SCHEME_NOTIFY

object DeepLinkProcessor {
    @JvmStatic
    @DeepLink(value = ["$SCHEME://$HOST", "$SCHEME://$HOST2"])
    fun Context.deeplinkGoToMainActivity(extras: Bundle) = extras.getString(DeepLink.URI)?.let {
        browse(it)
    }

    @JvmStatic
    @DeepLink(value = ["$SCHEME://$HOST/pokemon-{id}", "$SCHEME_NOTIFY://pokemon-{id}"])
    fun Context.deeplinkGoToPokemonActivity(): Intent {
        return Intent(this, PokemonActivity::class.java)
    }

    @JvmStatic
    @DeepLink("$SCHEME://$HOST/ability-{id}")
    fun Context.deeplinkGoToAbilityActivity(): Intent {
        return Intent(this, AbilityActivity::class.java)
    }
}


