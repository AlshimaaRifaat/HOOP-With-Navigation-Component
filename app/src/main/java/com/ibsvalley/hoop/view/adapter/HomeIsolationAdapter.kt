package com.ibsvalley.hoop.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibsvalley.hoop.Constants
import com.ibsvalley.hoop.R
import com.ibsvalley.hoop.model.HomeIsolationModel
import com.ibsvalley.hoop.view.adapter.HomeIsolationAdapter.HomeIsolationViewHolder

class HomeIsolationAdapter(
    var context: Context,
    homeIsolationModels: List<HomeIsolationModel>
) : RecyclerView.Adapter<HomeIsolationViewHolder>() {
    var homeIsolationModels: List<HomeIsolationModel> = homeIsolationModels
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeIsolationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_isolation_row, parent, false)
        return HomeIsolationViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: HomeIsolationViewHolder,
        position: Int
    ) {
        holder.name.setText(homeIsolationModels[position].title)
        holder.details.setText(homeIsolationModels[position].content)
        Glide.with(context)
            .load(Constants.IMAGE_BASE_URL + homeIsolationModels[position].image)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return homeIsolationModels.size
    }

    inner class HomeIsolationViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var name: TextView
        var details: TextView

        init {
            imageView = itemView.findViewById(R.id.image)
            name = itemView.findViewById(R.id.name)
            details = itemView.findViewById(R.id.details)
        }
    }

}