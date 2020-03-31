package com.ibsvalley.hoop.network

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import com.google.gson.Gson
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import com.google.gson.GsonBuilder
import com.ibsvalley.hoop.Constants
import com.ibsvalley.hoop.Constants.BASE_URL
import java.util.concurrent.TimeUnit
import kotlin.math.log


private val BasuRl: String = "https://thevirustracker.com/"
var NEW_BASE_URL = ""

val gson = GsonBuilder()
    .setLenient()
    .create()

val okHttpClient = OkHttpClient.Builder()
    .readTimeout(60, TimeUnit.SECONDS)
    .connectTimeout(60, TimeUnit.SECONDS)
    .build()


private fun providerOkHttpClient(): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
    okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
    okHttpClientBuilder.readTimeout(30, TimeUnit.SECONDS)
    okHttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS)
//
    return okHttpClientBuilder.build()
}


fun retrofitClient(context: Context): Retrofit? {




    Lang(context)
    return Retrofit.Builder()
        .baseUrl(NEW_BASE_URL)
        .client(providerOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()
}
fun Lang(context: Context) {


    var lang_code: String =
        context.getSharedPreferences("userData", Context.MODE_PRIVATE)
            ?.getString("mlang", "en")
            .toString()
    Log.i("eeeeeeeeeeeeee","asd"+lang_code)
    when (lang_code) {

        "ar" ->
            NEW_BASE_URL = BASE_URL + "ar-EG/api/"


        "en" ->
            NEW_BASE_URL = BASE_URL + "en-US/api/"

    }
}

object ApiClient {


    val retrofitService by lazy {

        Retrofit.Builder()
            .baseUrl(BasuRl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build().create(Api::class.java)


    }


}