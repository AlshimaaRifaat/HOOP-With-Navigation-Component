package com.ibsvalley.hoop.model


import com.google.gson.annotations.SerializedName
//import android.support.annotation.Keep
import androidx.annotation.Keep

@Keep
data class ReferncesModel(
    @SerializedName("Id") var id: Int,
    @SerializedName("RefrenceContent") var refrenceContent: String,
    @SerializedName("RefrenceImage") var refrenceImage: String
)