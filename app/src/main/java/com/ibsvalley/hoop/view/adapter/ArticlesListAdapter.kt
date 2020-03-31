package com.ibsvalley.hoop.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ibsvalley.hoop.Constants
import com.ibsvalley.hoop.R
import com.ibsvalley.hoop.loadImage
import com.ibsvalley.hoop.model.ArticlesListModel
import com.ibsvalley.hoop.view.fragment.article.ArticlesFragmentDirections
import kotlinx.android.synthetic.main.row_catgory.view.*


class ArticlesListAdapter(
    private var itemData: List<ArticlesListModel.ArticlesListModelItem?>,
    private val itemClick: (ArticlesListModel.ArticlesListModelItem) -> Unit
) :
    RecyclerView.Adapter<ArticlesListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_catgory, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return if (itemData.isNotEmpty())
            itemData.size
        else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemData[position]!!, itemClick)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            item: ArticlesListModel.ArticlesListModelItem,
            itemClick: (ArticlesListModel.ArticlesListModelItem) -> Unit
        ) {
            // UI Setting Code
            itemView.setOnClickListener { itemClick(item) }
            itemView.image.loadImage(Constants.IMAGE_BASE_URL + item.Image)
            itemView.titleArt.text = item.title
            itemView.date.text = item.content

            itemView.parentCardView.setOnClickListener {
                val nextAction = ArticlesFragmentDirections.actionArticlesFragmentToArticlesDetailsFragment()
                nextAction.artID = item.id
                Navigation.findNavController(it).navigate(nextAction)


            }

                //                val nextAction = HomeFragmentDirections.actionHomeActivityToArticlesFragment()
//                Navigation.findNavController(it).navigate(nextAction)



        }


    }


}
