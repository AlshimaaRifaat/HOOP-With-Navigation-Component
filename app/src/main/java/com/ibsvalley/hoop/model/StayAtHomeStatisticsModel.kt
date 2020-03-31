package com.ibsvalley.hoop.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class StayAtHomeStatisticsModel(
    @SerializedName("IN_Home") var iNHome: Int,
    @SerializedName("Num_Of_Days") var numOfDays: Int,
    @SerializedName("OUT_Home") var oUTHome: Int
)