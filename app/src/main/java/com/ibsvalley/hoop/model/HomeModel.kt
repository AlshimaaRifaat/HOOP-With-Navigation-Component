package com.ibsvalley.hoop.model

import android.content.Context
import com.ibsvalley.hoop.R

data class HomeModel(var itemName: String, var itemIcon: Int)
object HomeModelInteractions {
    fun setNavItems(context: Context): ArrayList<HomeModel> {
        val items = ArrayList<HomeModel>()
        items.add(HomeModel(context.getString(R.string.articles), R.drawable.news))
        items.add(HomeModel(context.getString(R.string.virus_test), R.drawable.virus))
        items.add(HomeModel(context.getString(R.string.faq), R.drawable.faq))
        items.add(HomeModel(context.getString(R.string.protection_measures), R.drawable.protect))
        items.add(HomeModel(context.getString(R.string.home_isolation), R.drawable.home))
        items.add(HomeModel(context.getString(R.string.stay_at_home), R.drawable.stay))
        items.add(HomeModel(context.getString(R.string.references), R.drawable.news))
        return items
    }
}