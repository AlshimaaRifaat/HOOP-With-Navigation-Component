package com.ibsvalley.hoop.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProtectMeasureModel {
    @SerializedName("Id")
    @Expose
    var id = 0
    @SerializedName("Question")
    @Expose
    var question: String? = null
    @SerializedName("Answer")
    @Expose
    var answer: String? = null

}