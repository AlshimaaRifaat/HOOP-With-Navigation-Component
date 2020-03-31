    package com.ibsvalley.hoop.view.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ibsvalley.hoop.LangSupport
import com.ibsvalley.hoop.R
import com.ibsvalley.hoop.view.fragment.splash.SplashFragment

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var lang_code: String =
            getSharedPreferences("userData", Context.MODE_PRIVATE)
                ?.getString("mlang", "en")
                .toString()

        setContentView(R.layout.activity_splash)



        supportFragmentManager.takeIf { savedInstanceState == null }
                ?.beginTransaction()
                ?.replace(R.id.container,
                    SplashFragment()
                )
                ?.commitNow()


    }

}