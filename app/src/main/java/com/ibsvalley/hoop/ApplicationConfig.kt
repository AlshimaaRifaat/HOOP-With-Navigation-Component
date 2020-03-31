package com.ibsvalley.hoop

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.preference.PreferenceManager
import android.util.Log
import com.ibsvalley.hoop.Constants.LANG
import java.util.*
import kotlin.math.log10


class ApplicationConfig : Application() {
    //
//
    override fun onCreate() {
        super.onCreate()


//        val dataSaver = PreferenceManager.getDefaultSharedPreferences(applicationContext)
//
//        var lang = dataSaver?.getString(LANG, "en")
//
//
//
//        Log.i("asdsadsadsa", "" + lang)
//        when (lang) {
//            "ar" -> changeLocale("ar", applicationContext)
//
//
//            "en" -> changeLocale("en", applicationContext)
//
//
//        }
    }

    //
    fun changeLocale(s: String, context: Context) {


        var locale = Locale(s)
        Locale.setDefault(locale)
        var config = Configuration()
        config.locale = locale
        context.resources.updateConfiguration(
            config,
            context.resources.displayMetrics
        )
    }

    companion object {
        fun instance() = ApplicationConfig()

    }
}
