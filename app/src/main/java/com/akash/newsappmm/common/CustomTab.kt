package com.akash.newsappmm.common

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

class CustomTab {
    fun openTab(
        context: Context,
        uri:String) {

        val package_name = "com.android.chrome"
        val builder = CustomTabsIntent.Builder()
            .setShowTitle(true)
            .setInstantAppsEnabled(true)
            .build()
        builder.intent.setPackage(package_name)
        builder.launchUrl(context, Uri.parse(uri))


    }
}