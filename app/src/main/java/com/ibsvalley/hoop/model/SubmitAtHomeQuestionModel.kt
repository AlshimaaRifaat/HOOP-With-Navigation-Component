package com.ibsvalley.hoop.model


import com.google.gson.annotations.SerializedName
//import android.support.annotation.Keep
import androidx.annotation.Keep

@Keep
data class SubmitAtHomeQuestionModel(
    @SerializedName("IN_Home") var iNHome: Int,
    @SerializedName("OUT_Home") var oUTHome: Int,
    @SerializedName("Result") var result: Boolean,
    @SerializedName("User_Message") var userMessage: String
)