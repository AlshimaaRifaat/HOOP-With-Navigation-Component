package com.ibsvalley.hoop.view.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.ibsvalley.hoop.*
import com.ibsvalley.hoop.model.ProtectMeasureModel
import com.ibsvalley.hoop.view.adapter.ProtectMeasureAdapter.ProtectMeasureViewHolder

class ProtectMeasureAdapter(
    var context: Context,
    homeIsolationModels: List<ProtectMeasureModel>
) : RecyclerView.Adapter<ProtectMeasureViewHolder>() {
    private  var lang: String=""
    private var homeIsolationModels: List<ProtectMeasureModel> = homeIsolationModels
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProtectMeasureViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.protection_measure_row, parent, false)
        return ProtectMeasureViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ProtectMeasureViewHolder,
        position: Int
    ) {



        diretionLang()

        holder.name.getSettings().setTextSize(WebSettings.TextSize.NORMAL);
        holder.details.getSettings().setTextSize(WebSettings.TextSize.NORMAL);



        holder.name.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        holder.details.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        holder.name.getSettings().setDefaultFontSize(14); //5 or any dmen you want
        holder.name.getSettings().setDefaultFontSize(14);
        homeIsolationModels[position].question?.let{ stringToWebView(holder.name, it, "en") }
        homeIsolationModels[position].answer?.let{ stringToWebView(holder.details, it, "en") }

        holder.parent.setOnClickListener {


            if (holder.details.visibility == View.VISIBLE) {
                holder.imageView.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp)
                holder.details.hide()

            } else {
                holder.details.show()
                holder.imageView.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp)

            }
        }




//

    }

    private fun diretionLang() {
        val pref: SharedPreferences =
            context.getSharedPreferences("lang", Context.MODE_PRIVATE)

        val language = pref.getString(Constants.LANG, "en")
        lang = if (language == "en") {
            "ltr"
        } else {
            "rtl"
        }

    }

    override fun getItemCount(): Int {
        return homeIsolationModels.size
    }

    inner class ProtectMeasureViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var name: WebView
        var details: WebView
        var parent: RelativeLayout

        init {
            imageView = itemView.findViewById(R.id.arrow)
            name = itemView.findViewById(R.id.name)
            details = itemView.findViewById(R.id.content)
            parent = itemView.findViewById(R.id.parent)
        }
    }

}