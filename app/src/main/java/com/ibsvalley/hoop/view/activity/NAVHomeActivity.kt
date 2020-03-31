package com.ibsvalley.hoop.view.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import com.ibsvalley.hoop.*
import com.ibsvalley.hoop.model.SideNavInteractions
import com.ibsvalley.hoop.view.adapter.SideNavAdapter
import kotlinx.android.synthetic.main.activity_navhome.*
import kotlinx.android.synthetic.main.activity_test_result.*
import kotlinx.android.synthetic.main.app_bar_home_nav.*
import kotlinx.android.synthetic.main.app_bar_home_nav.view.*
import kotlinx.android.synthetic.main.home_drawer_layout.*
import java.util.*


class NAVHomeActivity : LangSupport() {
    private var pressToExit = false


    companion object {
        var Flag: String = ""
        var FlagHereActivity: String = ""
        var homeTitleTv: TextView? = null


    }

//    var toolbar: Toolbar? = null


    private var dataSaver: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var lang_code: String =
            this.getSharedPreferences("userData", Context.MODE_PRIVATE)
                ?.getString("mlang", Locale.getDefault().language)
                .toString()
        setLocale(this, lang_code)

        setContentView(R.layout.activity_navhome)
//        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        toolbar.img_corona.show()

        drawerSetup()

        setActionBarTitle("", 1)
    }

    @SuppressLint("Range")
    fun setActionBarTitle(title: String?, flag: Int, backgroundTest: Int = 0, hexca: String = "") {

        toolbar.homeTitleTv.text = title
        if (flag == 2) {


            toolbar.img_corona.hide()


        } else {
            toolbar.img_corona.show()

        }
    }

    override fun onResume() {
        super.onResume()

    }

    private fun drawerSetup() {

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        toggle.apply {
            syncState()
            isDrawerIndicatorEnabled = false
            setHomeAsUpIndicator(R.drawable.menu)
            setToolbarNavigationClickListener { drawerLayout.openDrawer(GravityCompat.START) }
        }
        drawerLayout.addDrawerListener(toggle)

        sideNavRecycler.apply {
            adapter = SideNavAdapter(
                this@NAVHomeActivity,
                SideNavInteractions.setNavItems(this@NAVHomeActivity)
            ) {
                drawerLayout.closeDrawer(GravityCompat.START)
//

                when (it) {


                    0 -> {


                        this@NAVHomeActivity.setActionBarTitle(getString(R.string.articles), 2)
                        Navigation.findNavController(
                            this@NAVHomeActivity,
                            R.id.home_nav_host
                        ).navigate(R.id.articlesFragment)

                    }
                    1 -> {
                        this@NAVHomeActivity.setActionBarTitle(getString(R.string.virus_test), 2)


                        var dataSaver =
                            PreferenceManager.getDefaultSharedPreferences(this@NAVHomeActivity)
                        val In = dataSaver.getInt("counrty", 0)
                        if (In != 0) {

                            Navigation.findNavController(
                                this@NAVHomeActivity,
                                R.id.home_nav_host
                            ).navigate(R.id.userInFragment)

                        } else {
//

                            Navigation.findNavController(
                                this@NAVHomeActivity,
                                R.id.home_nav_host
                            ).navigate(R.id.chooseCountryFragment)
                        }
                    }
                    2 -> {
                        this@NAVHomeActivity.setActionBarTitle(getString(R.string.faq), 2)

//
                        Navigation.findNavController(
                            this@NAVHomeActivity,
                            R.id.home_nav_host
                        ).navigate(R.id.FAQFragment)

                    }
                    3 -> {
//
                        this@NAVHomeActivity.setActionBarTitle(
                            getString(R.string.protection_measures),
                            2
                        )

                        Navigation.findNavController(
                            this@NAVHomeActivity,
                            R.id.home_nav_host
                        ).navigate(R.id.protectionMeasureFragment)
                    }
                    4 -> {
                        this@NAVHomeActivity.setActionBarTitle(
                            getString(R.string.home_isolation),
                            2
                        )

                        Navigation.findNavController(
                            this@NAVHomeActivity,
                            R.id.home_nav_host
                        ).navigate(R.id.homeIsolationFragment)
//
//
                    }
                    5 -> {
                        this@NAVHomeActivity.setActionBarTitle(getString(R.string.stay_at_home1), 2)

                        Navigation.findNavController(
                            this@NAVHomeActivity,
                            R.id.home_nav_host
                        ).navigate(R.id.stayAtHomeStatisticsFragment)

                    }
                    6 -> {
                        this@NAVHomeActivity.setActionBarTitle(getString(R.string.references), 2)

                        Navigation.findNavController(
                            this@NAVHomeActivity,
                            R.id.home_nav_host
                        ).navigate(R.id.refrencesFragment)

                    }


                    7 -> {
                        val lang_code =
                            context.getSharedPreferences(
                                "userData",
                                AppCompatActivity.MODE_PRIVATE
                            ).getString(
                                "mlang",
                                Locale.getDefault().language
                            ) //load it from SharedPref
                        var user_data = context.getSharedPreferences(
                            "userData",
                            AppCompatActivity.MODE_PRIVATE
                        )
                        var editor = user_data.edit()


                        if (lang_code == "ar") {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                editor.putString("mlang", "en")
                                editor.apply()
                                finish()
                                startActivity(intent)
                                ContextWrapper.setLocale(this@NAVHomeActivity, "en")
                            } else {
                                ContextWrapper.setLocale(this@NAVHomeActivity, "ar")

                                editor.putString("mlang", "en")
                                editor.apply()

                            }
                        } else if (lang_code == "en") {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                editor.putString("mlang", "ar")
                                editor.apply()
                                finish()
                                startActivity(intent)

                                ContextWrapper.setLocale(this@NAVHomeActivity, "ar")

                            } else {
                                ContextWrapper.setLocale(this@NAVHomeActivity, "ar")

                                editor.putString("mlang", "ar")
                                editor.apply()
                            }


                        }
                    }


                }

            }

        }
    }


    override fun onBackPressed() {
        if (Flag.isNotEmpty()) {
            Flag = ""
            goTo(NAVHomeActivity())
            finishAffinity()
        } else {
//            if (FlagHereActivity.isNotEmpty()) {
//                if (pressToExit) {
//                    super.onBackPressed()
//                    return
//                }
//                pressToExit = true
//                toast(getString(R.string.press_to_exit))
//                Handler().postDelayed({ pressToExit = false }, 2000)
//
//            } else {
            super.onBackPressed()
//            }
        }
    }


}



