package com.ibsvalley.hoop.view.fragment.splash

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import com.ibsvalley.hoop.Constants.LANG
import com.ibsvalley.hoop.ContextWrapper.Companion.setLocale
import com.ibsvalley.hoop.R
import com.ibsvalley.hoop.goTo
import com.ibsvalley.hoop.view.activity.NAVHomeActivity
import kotlinx.android.synthetic.main.fragment_language.*
import java.util.*


class LanguageFragment : Fragment(R.layout.fragment_language) {
    var user_data: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)





        // checkbox = findViewById(R.id.checkbox);





        arTv.setOnClickListener {

            var dataSaver = activity?.let { PreferenceManager.getDefaultSharedPreferences(it) }
            user_data = activity?.getSharedPreferences("userData", MODE_PRIVATE)
            editor = user_data?.edit()
            editor?.apply()

            dataSaver?.edit()?.putString(LANG, "ar")?.apply()

            dataSaver?.edit()?.putInt("goto", 15)?.apply()

            activity?.let { it1 -> setLocale(it1,"ar") }

            activity?.finish()



            editor!!.putString("mlang", "ar")
            editor!!.apply()

//
//            activity!!.goTo(HomeFragment())
//            activity!!.finishAffinity()


        }



        enTv.setOnClickListener {
            var lang_code: String =
                activity?.getSharedPreferences("userData", MODE_PRIVATE)
                    ?.getString("mlang", Locale.getDefault().language)
                    .toString() //load it from SharedPref
            user_data = activity?.getSharedPreferences("userData", MODE_PRIVATE)
            editor = user_data?.edit()
            editor?.apply()
            var dataSaver = activity?.let { PreferenceManager.getDefaultSharedPreferences(it) }

            dataSaver?.edit()?.putInt("goto", 15)?.apply()
            dataSaver?.edit()?.putString(LANG, "en")?.apply()

            editor?.putString("mlang", "en")
            editor?.apply()

            activity?.let { it1 -> setLocale(it1,"en") }
//
            activity!!.goTo(NAVHomeActivity())
            activity!!.finishAffinity()



        }



    }
}
