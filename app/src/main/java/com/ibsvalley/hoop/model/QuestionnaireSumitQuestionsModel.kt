package com.ibsvalley.hoop.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class QuestionnaireSumitQuestionsModel(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Result")
    val result: Boolean,
    @SerializedName("User_Message")
    val userMessage: String,
    @SerializedName("Result_Flag")
    val resultFlag: Int,
    @SerializedName("Test_Result")
    val testResult: String
)