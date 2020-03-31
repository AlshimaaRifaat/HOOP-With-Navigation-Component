package com.ibsvalley.hoop.view.fragment

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import com.ibsvalley.hoop.*
import com.ibsvalley.hoop.model.HomeModelInteractions
import com.ibsvalley.hoop.view.activity.NAVHomeActivity
import com.ibsvalley.hoop.view.adapter.HomeAdapter
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeFragment : Fragment(R.layout.activity_home) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        NAVHomeActivity.FlagHereActivity =""
        var lang_code: String =
            activity?.getSharedPreferences("userData", Context.MODE_PRIVATE)
                ?.getString("mlang", Locale.getDefault().language)
                .toString()
        activity?.let { ContextWrapper.setLocale(it, lang_code) }

        var dataSaver =
            PreferenceManager.getDefaultSharedPreferences(requireContext())

        dataSaver?.edit()?.putString("ArDisable", "")?.apply()

        HomeRecycler.apply {
            adapter = activity?.let { HomeModelInteractions.setNavItems(it) }?.let {
                HomeAdapter(
                    it
                , (activity as NAVHomeActivity?)!!

                )

            }
        }
    }
    override fun onResume() {
        super.onResume()
        (context as NAVHomeActivity).setActionBarTitle("",1)

    }
}


//
//        HomeRecycler.apply {
//                        adapter = activity?.let { HomeModelInteractions.setNavItems(it) }?.let {
//                            HomeAdapter(
//                                it
//                            )
//                        }
//
//        }


//        HomeRecycler.apply {
//            adapter = activity?.let { HomeModelInteractions.setNavItems(it) }?.let { HomeAdapter(it) }
//        }

//        rcArticlesList.apply {
//            adapter = ArticlesListAdapter(it)
//            { item ->
//                //                    goTo(ArticlesDetailsFragment(), "dest", "${item.id}")
//            }
//        }


////                    when (it) {
////
////
//                        0 -> {
//
//
////
//                            val nextAction = HomeFragmentDirections.actionHomeActivityToArticlesFragment()
//                            Navigation.findNavController(activity!!,0).navigate(nextAction)
//
//////                            nextAction.leagueId = get.id
////                            Navigation.findNavController().navigate(nextAction)
//                        }
//
//                        //                    1 -> {
//                        //
//                        //                        var dataSaver =
//                        //                            PreferenceManager.getDefaultSharedPreferences(applicationContext)
//                        //                        val In = dataSaver?.getInt("counrty", 0)
//                        //                        if (In != 0) {
//                        //                            goTo(UserInFragment())
//                        //
//                        //                        } else {
//                        //                            goTo(ChooseCountryFragment())
//                        //
//                        //                        }
//                        //
//                        //                    }
//                        //
//                        //
//                        //                    2 -> {
//                        //                        goTo(FAQFragment())
//                        //                    }
//                        //
//                        //                    3 -> {
//                        //                        goTo(ProtectionMeasureFragment())
//                        //                    }
//                        //
//                        //                    4 -> {
//                        //                        goTo(HomeIsolationFragment())
//                        //
//                        //                    }
//                        //
//                        //                    5 -> {
//                        //                        goTo(StayAtHomeStatisticsFragment())
//                        //
//                        //
//                        //                    }
//                        //                    6 -> {
//                        //                        goTo(RefrencesFragment())
//                        //
//                        //
//                        //                    }
//                        //
//                        //                    7 -> {
//                        //                        val lang_code =
//                        //                            getSharedPreferences("userData", MODE_PRIVATE).getString(
//                        //                                "mlang",
//                        //                                Locale.getDefault().language
//                        //                            ) //load it from SharedPref
//                        //                        var user_data = getSharedPreferences("userData", MODE_PRIVATE)
//                        //                        var editor = user_data.edit()
//                        //
//                        //
//                        //                        if (lang_code == "ar") {
//                        //                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                        //                                editor.putString("mlang", "en")
//                        //                                editor.apply()
//                        //                                finishAffinity()
//                        //                                startActivity(intent)
//                        //                                setLocale(this@HomeFragment, "en")
//                        //                            } else {
//                        //                                setLocale(this@HomeFragment, "ar")
//                        //
//                        //                                editor.putString("mlang", "en")
//                        //                                editor.apply()
//                        //
//                        //                            }
//                        //                        } else if (lang_code == "en") {
//                        //                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                        //                                editor.putString("mlang", "ar")
//                        //                                editor.apply()
//                        //                                finishAffinity()
//                        //                                startActivity(intent)
//                        //                                setLocale(this@HomeFragment, "ar")
//                        //
//                        //                            } else {
//                        //                                setLocale(this@HomeFragment, "ar")
//                        //
//                        //                                editor.putString("mlang", "ar")
//                        //                                editor.apply()
//                        //                            }
//                        //
//                        //
//                        //                        }
//                        //                    }
//
//                        //
//
//                    }
//


//    override fun onBackPressed() {
//        if (pressToExit) {
//            super.onBackPressed()
//            return
//        }
//        pressToExit = true
//        toast(getString(R.string.press_to_exit))
//        Handler().postDelayed({ pressToExit = false }, 2000)
//
//    }

