package com.ibsvalley.hoop.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ibsvalley.hoop.Constants
import com.ibsvalley.hoop.R
import com.ibsvalley.hoop.Selection_Multi_Selected
import com.ibsvalley.hoop.Selection_Multi_Selected1
import com.ibsvalley.hoop.model.QuestionsAndAnswers_ListModel
import com.ibsvalley.hoop.view.adapter.ParentOvalAdapter.ParentHolder
import java.util.*

class ParentOvalAdapter(
    private val modelList: QuestionsAndAnswers_ListModel,
    private var context: Context

) : RecyclerView.Adapter<ParentHolder>() {
    private val ids =
        Selection_Multi_Selected1.selection_multi_selected().ids
    private var SS: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ParentHolder {
        return ParentHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.parent_oval_row,
                parent,
                false
            )
        )
    }

    @SuppressLint("UseSparseArrays")
    override fun onBindViewHolder(holder: ParentHolder, i: Int) {
        holder.size.text = modelList[i].questionText

        holder.yes.setOnClickListener {

            if (ids.containsKey(modelList[i].id)) {
                ids.remove(modelList[i].id)

            }
            ids.put(modelList[i].id, Constants.YES)



        }



        holder.no.setOnClickListener {

            if (ids.containsKey(modelList[i].id)) {

                ids.remove(modelList[i].id)

            }
            ids.put(modelList[i].id, Constants.NO)





        }

    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    public class ParentHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val size: TextView = itemView.findViewById(R.id.size)
        val yes: TextView = itemView.findViewById(R.id.yes)
        val no: TextView = itemView.findViewById(R.id.no)

    }

}