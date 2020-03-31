package com.ibsvalley.hoop.view.adapter

import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ibsvalley.hoop.R
import com.ibsvalley.hoop.model.HomeModel
import com.ibsvalley.hoop.view.activity.NAVHomeActivity
import com.ibsvalley.hoop.view.fragment.HomeFragmentDirections
import kotlinx.android.synthetic.main.home_item_row.view.*


class HomeAdapter(
    private val itemData: ArrayList<HomeModel>, private val context: NAVHomeActivity
//    ,
//    private val toolbar: Toolbar
) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.home_item_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return if (itemData.isNotEmpty())
            itemData.size
        else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemData[position], position, context)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            item: HomeModel,
            position: Int,
            context: NAVHomeActivity?
        ) {
            // UI Setting Code
            itemView.title.apply {

                text = item.itemName


            }
            itemView.img_faq.apply {
                setImageDrawable(resources.getDrawable(item.itemIcon))
            }
//
            itemView.setOnClickListener {

                when (position) {
                    0 -> {
                        val nextAction =
                            HomeFragmentDirections.actionHomeActivityToArticlesFragment()
                        Navigation.findNavController(it).navigate(nextAction)
                        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.articles),2)


                    }
                    1 -> {

                        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.virus_test),2)


                        var dataSaver =
                            PreferenceManager.getDefaultSharedPreferences(context)
                        val In = dataSaver?.getInt("counrty", 0)


                        if (In != 0) {
                            val nextAction =
                                HomeFragmentDirections.actionHomeActivityToUserInFragment()
                            Navigation.findNavController(it).navigate(nextAction)


                        } else {
                            val nextAction =
                                HomeFragmentDirections.actionHomeActivityToChooseCountryFragment()
                            Navigation.findNavController(it).navigate(nextAction)
//                            context?.getNotificationsBadge()?.text  = context?.getText(R.string.virus_test)

                        }
                    }
                    2 -> {

                        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.faq),2)

                        val nextAction =
                            HomeFragmentDirections.actionHomeActivityToFAQFragment()
                        Navigation.findNavController(it).navigate(nextAction)

//                        context?.homeTitleTv()?.text = context?.getText(R.string.faq)
//                        context?.getNotificationsBadge()?.text  = context?.getText(R.string.faq)

                    }
                    3 -> {
                        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.protection_measures),2)
//
////                        context?.homeTitleTv()?.text =
//                        context?.getText(R.string.protection_measures)
                        val nextAction =
                            HomeFragmentDirections.actionHomeActivityToProtectionMeasureFragment()
                        Navigation.findNavController(it).navigate(nextAction)
//                        context?.getNotificationsBadge()?.text  =


                    }
                    4 -> {
                        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.home_isolation),2)

                        val nextAction =
                            HomeFragmentDirections.actionHomeActivityToHomeIsolationFragment()
                        Navigation.findNavController(it).navigate(nextAction)
//                        context?.getNotificationsBadge()?.text  =
//                        context?.homeTitleTv()?.text = context?.getText(R.string.home_isolation)


                    }
                    5 -> {
                        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.stay_at_home),2)
                        val nextAction =
                            HomeFragmentDirections.actionHomeActivityToStayAtHomeStatisticsFragment()
                        Navigation.findNavController(it).navigate(nextAction)
//                        context?.getNotificationsBadge()?.text  =
//                        context?.homeTitleTv()?.text = context?.getText(R.string.stay_at_home)

                    }
                    6 -> {
                        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.references),2)

                        val nextAction =
                            HomeFragmentDirections.actionHomeActivityToRefrencesFragment()
                        Navigation.findNavController(it).navigate(nextAction)
//                        context?.getNotificationsBadge()?.text  =
//                        context?.homeTitleTv()?.text = context?.getText(R.string.references)

                    }
                }


            }
        }
    }
}
