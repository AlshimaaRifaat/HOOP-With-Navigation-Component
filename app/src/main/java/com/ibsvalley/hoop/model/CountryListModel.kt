package com.ibsvalley.hoop.model


import com.google.gson.annotations.SerializedName

class CountryListModel : ArrayList<CountryListModel.CountryListModelItem>(){

    data class CountryListModelItem(
        @SerializedName("Id")
        val id: Int,
        @SerializedName("Name")
        val name: String
    )
}