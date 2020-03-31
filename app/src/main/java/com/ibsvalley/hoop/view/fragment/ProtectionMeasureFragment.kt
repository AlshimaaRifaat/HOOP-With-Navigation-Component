package com.ibsvalley.hoop.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ibsvalley.hoop.*
import com.ibsvalley.hoop.model.ProtectMeasureModel
import com.ibsvalley.hoop.network.Api
import com.ibsvalley.hoop.network.retrofitClient
import com.ibsvalley.hoop.view.activity.NAVHomeActivity

import com.ibsvalley.hoop.view.adapter.ProtectMeasureAdapter
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.activity_protection_measure.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ProtectionMeasureFragment :Fragment(R.layout.activity_protection_measure){

    private var kProgressHUD: KProgressHUD? = null
    var protectMeasureAdapter: ProtectMeasureAdapter? = null
    var layoutManager: GridLayoutManager? = null


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

            (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.protection_measures),2)

        var lang_code: String =
            activity?.getSharedPreferences("userData", Context.MODE_PRIVATE)
                ?.getString("mlang", Locale.getDefault().language)
                .toString()
        activity?.let { ContextWrapper.setLocale(it, lang_code) }
        NAVHomeActivity.FlagHereActivity =""

        kProgressHUD = activity?.let { getKProgressHUD(it) }

        protectMeasure()



    }



    fun protectMeasure() {
        kProgressHUD?.show()

        activity?.let {
            retrofitClient(it)?.create(Api::class.java)?.protectMeasure()
                ?.enqueue(object : Callback<List<ProtectMeasureModel?>?> {
                    override fun onResponse(
                        call: Call<List<ProtectMeasureModel?>?>,
                        response: Response<List<ProtectMeasureModel?>?>
                    ) {
                        if (response.isSuccessful) {
                            Log.e("TAG", "isSuccessful")
                            kProgressHUD?.dismiss()
                            protectMeasureAdapter =
                                ProtectMeasureAdapter(
                                    activity!!,
                                    response.body() as List<ProtectMeasureModel>
                                )
                            protection_measure_recycler!!.adapter = protectMeasureAdapter
                        } else {
                            kProgressHUD?.dismiss()
                            Log.e("TAG", "notSuccessful")
                        }
                    }

                    override fun onFailure(
                        call: Call<List<ProtectMeasureModel?>?>,
                        t: Throwable
                    ) {
                        Log.e("TAG ", "onFailure")
                        kProgressHUD?.dismiss()

                        activity!!.toast(getString(R.string.error))
                    }
                })
        }
    }
    override fun onResume() {
        super.onResume()
        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.protection_measures),2)

    }


}