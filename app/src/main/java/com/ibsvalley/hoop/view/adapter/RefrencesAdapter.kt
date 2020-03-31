package com.ibsvalley.hoop.view.adapter

import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ibsvalley.hoop.Constants
import com.ibsvalley.hoop.R
import com.ibsvalley.hoop.loadImage
import com.ibsvalley.hoop.model.ReferncesModel
import kotlinx.android.synthetic.main.row_catgory.view.*

class RefrencesAdapter (val referncesList: List<ReferncesModel>) : RecyclerView.Adapter<RefrencesAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RefrencesAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_references, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: RefrencesAdapter.ViewHolder, position: Int) {
        holder.bindItems(referncesList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return referncesList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(referncesModel: ReferncesModel) {
            val img = itemView.findViewById(R.id.img) as ImageView
            val T_link  = itemView.findViewById(R.id.T_link) as TextView

            img.loadImage(Constants.IMAGE_BASE_URL+referncesModel.refrenceImage)
            T_link.text = referncesModel.refrenceContent
            Linkify.addLinks(T_link, Linkify.WEB_URLS);
        }
    }
}