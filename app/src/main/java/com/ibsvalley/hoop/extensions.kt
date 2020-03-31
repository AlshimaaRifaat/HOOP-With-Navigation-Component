package com.ibsvalley.hoop

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.ibsvalley.hoop.ContextWrapper.Companion.changeLang
import com.kaopiz.kprogresshud.KProgressHUD
import java.util.*


fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}


fun AppCompatActivity.scrollable() {
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    window.setSoftInputMode(
        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
    )
}

fun Context.goTo(dest: AppCompatActivity, name: String = "", value: String = "") {
    startActivity(Intent(this, dest::class.java).apply {
        putExtra(name, value)
    })
}


class GenderSpinnerAdapter(context: Context, resource: Int) :
    ArrayAdapter<String?>(context, resource) {
    override fun getCount(): Int {
        val count = super.getCount()
        return if (count > 0) count - 1 else count
    }
}

class Selection_Multi_Selected {
    val ids = mutableListOf<String>()

    companion object {
        private val selection_multi_selected = Selection_Multi_Selected()
        fun selection_multi_selected(): Selection_Multi_Selected {
            return selection_multi_selected
        }
    }
}


fun getKProgressHUD(context: Context): KProgressHUD? {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        return KProgressHUD.create(context)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setLabel(context.getString(R.string.please_wait))
            .setCancellable(false)
            .setAnimationSpeed(1)
            .setDimAmount(0.5f)
            .setBackgroundColor(context.getColor(R.color.colorPrimary))
    }

    return KProgressHUD.create(context)
        .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
        .setLabel("please_wait")
        .setCancellable(false)
        .setAnimationSpeed(1)
        .setDimAmount(0.5f)

}

class Selection_Multi_Selected1 {
    var ids: HashMap<Int, Int> = HashMap()


    companion object {
        private val selection_multi_selected1 = Selection_Multi_Selected1()
        fun selection_multi_selected(): Selection_Multi_Selected1 {
            return selection_multi_selected1
        }
    }
}
class Selection_LANG {
    var LANG: String = ""


    companion object {
        private var selection_LANG = Selection_LANG()
        fun Selection_LANG(): Selection_LANG {
            return selection_LANG
        }
    }
}


fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).placeholder(getCircularProgressDrawable(this.rootView.context))
        .into(this)
}


fun getCircularProgressDrawable(view: Context): CircularProgressDrawable? {
    val circularProgressDrawable = CircularProgressDrawable(view)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        circularProgressDrawable.setColorSchemeColors(view.getColor(R.color.colorAccent));
    }
    circularProgressDrawable.start()
    return circularProgressDrawable
}


fun stringToWebView(
    webview: WebView,
    data: String,

    rtl: String
) {
    val data2 = "<div style='direction:$rtl !important; '>$data</div>"
    webview.settings.javaScriptEnabled = true
    webview.settings.defaultZoom = WebSettings.ZoomDensity.FAR
    webview.loadDataWithBaseURL("", data2, "text/html", "UTF-8", "")
    webview.settings.textZoom


    //        webview.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
}

open class LangSupport : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context) { //        String lang_code//
//
        val string = newBase.getSharedPreferences("userData", MODE_PRIVATE)
            .getString("mlang", Locale.getDefault().language)
        val context: Context = changeLang(newBase, Locale(string))
        super.attachBaseContext(context)
    }

    open fun setLocale(activity: Activity, lang: String?) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        activity.resources.updateConfiguration(config, null)
    }



}

