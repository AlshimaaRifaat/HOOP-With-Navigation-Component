package com.ibsvalley.hoop.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ibsvalley.hoop.network.Api
import com.ibsvalley.hoop.network.retrofitClient
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ReferncesViewModel :ViewModel(){
    public var refrencesListMutableLiveData: MutableLiveData<List<ReferncesModel>>? = null
    private lateinit var context: Context


    public fun getRefrencesList(
        context: Context
    ): LiveData<List<ReferncesModel>> {
        refrencesListMutableLiveData = MutableLiveData<List<ReferncesModel>>()
        this.context = context
        getRefrencesListValues()

        //  return listProductsMutableLiveData
        return refrencesListMutableLiveData as MutableLiveData<List<ReferncesModel>>

    }

    private fun getRefrencesListValues() {
        val call = retrofitClient(context)?.create(Api::class.java)
            ?.refrences_List()
        call?.enqueue(object : Callback, retrofit2.Callback<List<ReferncesModel>> {
            override fun onResponse(
                call: Call<List<ReferncesModel>>,
                response: Response<List<ReferncesModel>>
            ) {

                if (response.code() == 200) {
                    refrencesListMutableLiveData?.setValue(response.body())

                } else {
                    refrencesListMutableLiveData?.setValue(null)
                }
            }

            override fun onFailure(call: Call<List<ReferncesModel>>, t: Throwable) {
                refrencesListMutableLiveData?.setValue(null)

            }
        })


    }
}