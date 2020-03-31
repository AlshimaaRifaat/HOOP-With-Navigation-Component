package com.ibsvalley.hoop.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HomeIsolationModel {
    @SerializedName("Id")
    @Expose
    var id = 0
    @SerializedName("Title")
    @Expose
    var title: String? = null
    @SerializedName("Content")
    @Expose
    var content: String? = null
    @SerializedName("Image")
    @Expose
    var image: String? = null

}