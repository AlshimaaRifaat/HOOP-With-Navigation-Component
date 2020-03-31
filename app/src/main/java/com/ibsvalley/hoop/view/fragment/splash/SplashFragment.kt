package com.ibsvalley.hoop.view.fragment.splash

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import com.ibsvalley.hoop.R
import com.ibsvalley.hoop.goTo
import com.ibsvalley.hoop.view.activity.NAVHomeActivity


class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var dataSaver = activity?.let { PreferenceManager.getDefaultSharedPreferences(it) }





        val int = dataSaver?.getInt("goto", 0)


//        activity?.let { changeLang(dataSaver?.getString( LANG,"en"), it) }

        Handler().postDelayed(
            {
                if (int != 0) {
                    activity!!.goTo(NAVHomeActivity())
                    activity!!.finish()
                } else {

                    activity?.supportFragmentManager.takeIf { savedInstanceState == null }
                        ?.beginTransaction()
                        ?.replace(R.id.container, LanguageFragment())
                        ?.commitNow()




                }
            }
            , 3000
        )


    }

    fun changeLang(lang: String?, c: Context) {
//        var locale = Locale(lang)
//        Locale.setDefault(locale)
//        var config = Configuration()
//        config.locale = locale
//        c.resources.updateConfiguration(
//            config,
//            c.resources.displayMetrics
//        )
    }

}

