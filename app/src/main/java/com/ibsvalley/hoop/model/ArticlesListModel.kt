package com.ibsvalley.hoop.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

class ArticlesListModel : ArrayList<ArticlesListModel.ArticlesListModelItem>() {
    @Keep
    data class ArticlesListModelItem(
        @SerializedName("Id")
        val id: Int,
        @SerializedName("Title")
        val title: String,
        @SerializedName("Date")
        val date: String,
        @SerializedName("Content")
        val content: String,
        @SerializedName("Author")
        val author: String,
        @SerializedName("Author_Title")
        val authorTitle: String,
        @SerializedName("Image")
        val Image: String,
        @SerializedName("DoctorImage")
        val DoctorImage: String
    )
}