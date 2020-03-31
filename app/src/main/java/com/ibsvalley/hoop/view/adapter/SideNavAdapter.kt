package com.ibsvalley.hoop.view.adapter

import android.content.Context
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibsvalley.hoop.Constants
import com.ibsvalley.hoop.R
import com.ibsvalley.hoop.model.SideNavModel
import kotlinx.android.synthetic.main.side_nav_item_row.view.*
import java.util.*
import kotlin.collections.ArrayList

class SideNavAdapter(private val context: Context,
    private val itemData: ArrayList<SideNavModel>,
    private val itemClick: (Int) -> Unit
) :
    RecyclerView.Adapter<SideNavAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.side_nav_item_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return if (itemData.isNotEmpty())
            itemData.size
        else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemData[position], position, itemClick,context)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            item: SideNavModel,
            position: Int,
            itemClick: (Int) -> Unit,
            context: Context
        ) {
            // UI Setting Code
            itemView.sideNavOptionTv.apply {
                text = item.itemName




                var lang_code: String =
                    context?.getSharedPreferences("userData", Context.MODE_PRIVATE)
                        ?.getString("mlang", Locale.getDefault().language)
                        .toString()
                when (lang_code) {

                    "ar" -> {
                        setCompoundDrawablesRelativeWithIntrinsicBounds(item.itemIcon, 0, 0, 0)

                    }

                    "en" -> {
                        setCompoundDrawablesRelativeWithIntrinsicBounds(0 ,0,item.itemIcon, 0)

                    }
                }
                
                

            }
            itemView.setOnClickListener { itemClick(position) }
        }
    }
}
