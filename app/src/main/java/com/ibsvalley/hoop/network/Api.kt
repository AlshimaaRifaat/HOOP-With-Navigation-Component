package com.ibsvalley.hoop.network

import android.content.Context
import android.util.Log
import com.ibsvalley.hoop.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*


interface Api {

    @GET("Statistics/StayAtHomeStatistics")
    fun stayAtHomeStatistics(): Call<StayAtHomeStatisticsModel>

    @GET("Home/Refrences_List")
    fun refrences_List(): Call<List<ReferncesModel>>
    @GET("free-api")
    fun egyptStatistics(@Query("countryTotal") countryTotal: String): Call<EgyptStatisticsModel>


    @GET("Home/Protection_measuresList")
    fun protectMeasure(): Call<List<ProtectMeasureModel?>?>?

    @GET("Home/PopularQuestionList")
    fun PopularQuestionList(): Call<List<ProtectMeasureModel?>?>?
    @FormUrlEncoded
    @POST("Statistics/SubmitAtHomeQuestion")
    fun submitAtHomeQuestion(
        @Field("DeviceName") DeviceName: String,
        @Field("Choice") Choice: String
    ): Call<SubmitAtHomeQuestionModel>

    @GET("Questionnaire/CountryList")
    fun country(): Call<CountryListModel>

    @GET("Home/ArticlesList?ArticleId=")
    fun articlesList(): Call<ArticlesListModel>

    @GET("Home/ArticlesList")
    fun articlesList(@Query("ArticleId") ArticleId: Int): Call<ArticlesListModel>

    @GET("Questionnaire/StateList")
    fun city(@Query("countryId") countryId: Int): Call<CountryListModel>

    @GET("Questionnaire/QuestionsAndAnswers_List?QuestionnaireId=1")
    fun questionnaire(): Call<QuestionsAndAnswers_ListModel>
    @GET("Home/HomeIsolationList")
    fun homeIsolation(): Call<List<HomeIsolationModel?>?>?

    @FormUrlEncoded
    @POST("Questionnaire/SumitQuestions")
    fun SumitQuestions(
        @Field("ClientName") ClientName: String,
        @Field("Phone") Phone: String?,
        @Field("CountryId") CountryId: Int?,
        @Field("CityId") CityId: Int?,
        @Field("Age") Age: Int?,
        @Field("Gender") Gender: String?,
        @Field("Json") Json:String,
        @Field("DeviceId") DeviceId: String
    ): Call<QuestionnaireSumitQuestionsModel?>?
}

//
object ArticlesListCall {

    private val TAG = this::class.java.simpleName

    fun getArticlesListApi(context: Context,callSuccess: (ArticlesListModel) -> Unit, callError: (Int) -> Unit) {
         val client =
            retrofitClient(context)?.create(Api::class.java)
        if (client != null) {
            client.articlesList().enqueue(object : Callback<ArticlesListModel> {
                override fun onFailure(call: Call<ArticlesListModel>, t: Throwable) {
                    call.cancel()
    //                Log.i(TAG, t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ArticlesListModel>,
                    response: Response<ArticlesListModel>
                ) {
                    Log.i(TAG, "${response.body()}")

                    if (response.body() != null) {
                        callSuccess(response.body()!!)

                    } else {
                        Log.i(TAG, "${response.errorBody()?.string()}")
                        callError(1)
                    }
                }

            })
        }
    }
}

object ArticlesListIdCall {



    private val TAG = this::class.java.simpleName

    fun getArticlesListApi(
   context: Context ,
        id: Int,
        callSuccess: (ArticlesListModel) -> Unit,
        callError: (Int) -> Unit
    ) {

            retrofitClient(context)?.create(Api::class.java)?.articlesList(id)?.enqueue(object : Callback<ArticlesListModel> {
                override fun onFailure(call: Call<ArticlesListModel>, t: Throwable) {
                    call.cancel()
        //                Log.i(TAG, t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ArticlesListModel>,
                    response: Response<ArticlesListModel>
                ) {
                    Log.i(TAG, "${response.body()}")

                    if (response.body() != null) {
                        callSuccess(response.body()!!)

                    } else {
                        Log.i(TAG, "${response.errorBody()?.string()}")
                        callError(1)
                    }
                }

            })
    }
}

object QuestionnaireCall {

    private val TAG = this::class.java.simpleName

    fun getQuestionnaireApi(context: Context,
        callSuccess: (QuestionsAndAnswers_ListModel) -> Unit,
        callError: (Int) -> Unit
    ) {
       val client = retrofitClient(context)?.create(Api::class.java)
        client?.questionnaire()?.enqueue(object : Callback<QuestionsAndAnswers_ListModel> {
            override fun onFailure(call: Call<QuestionsAndAnswers_ListModel>, t: Throwable) {
                call.cancel()
                //                Log.i(TAG, t.localizedMessage)
            }

            override fun onResponse(
                call: Call<QuestionsAndAnswers_ListModel>,
                response: Response<QuestionsAndAnswers_ListModel>
            ) {
                Log.i(TAG, "${response.body()}")

                if (response.body() != null) {
                    callSuccess(response.body()!!)

                } else {
                    Log.i(TAG, "${response.errorBody()?.string()}")
                    callError(1)
                }
            }

        })
    }}
