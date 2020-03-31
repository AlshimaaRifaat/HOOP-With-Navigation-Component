package com.ibsvalley.hoop.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

class QuestionsAndAnswers_ListModel : ArrayList<QuestionsAndAnswers_ListModel.QuestionsAndAnswers_ListModelItem>(){
    @Keep
    data class QuestionsAndAnswers_ListModelItem(
        @SerializedName("Id")
        val id: Int,
        @SerializedName("Question_Text")
        val questionText: String,
        @SerializedName("QuestionType")
        val questionType: String,
        @SerializedName("QuestionAnswersIds")
        val questionAnswersIds: List<Int>,
        @SerializedName("Answers_Text")
        val answersText: List<String>
    )
}