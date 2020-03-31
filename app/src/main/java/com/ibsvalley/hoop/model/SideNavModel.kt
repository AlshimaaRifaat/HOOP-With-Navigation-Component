package com.ibsvalley.hoop.model

import android.content.Context
import com.ibsvalley.hoop.R

data class SideNavModel(var itemName: String, var itemIcon: Int)
object SideNavInteractions {
    fun setNavItems(context: Context): ArrayList<SideNavModel> {
        val items = ArrayList<SideNavModel>()


        items.add(SideNavModel(context.getString(R.string.articles),0))
        items.add(SideNavModel(context.getString(R.string.virus_test),0))
        items.add(SideNavModel(context.getString(R.string.faq),0))
        items.add(SideNavModel(context.getString(R.string.protection_measures),0))
        items.add(SideNavModel(context.getString(R.string.home_isolation),0))
        items.add(SideNavModel(context.getString(R.string.stay_at_home),0))
        items.add(SideNavModel(context.getString(R.string.references),0))
        items.add(SideNavModel(context.getString(R.string.language),R.drawable.ic_world))
        return items
    }




}