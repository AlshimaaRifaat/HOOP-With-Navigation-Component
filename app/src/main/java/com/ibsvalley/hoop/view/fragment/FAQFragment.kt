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
import kotlinx.android.synthetic.main.activity_faq.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class FAQFragment : Fragment(R.layout.activity_faq) {
    private var client: Api? = null

    private var kProgressHUD: KProgressHUD? = null
    var protectMeasureAdapter: ProtectMeasureAdapter? = null
    var layoutManager: GridLayoutManager? = null
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        NAVHomeActivity.FlagHereActivity =""

        var lang_code: String =
            activity?.getSharedPreferences("userData", Context.MODE_PRIVATE)
                ?.getString("mlang", Locale.getDefault().language)
                .toString()
        activity?.let { ContextWrapper.setLocale(it, lang_code) }
        kProgressHUD = activity?.let { getKProgressHUD(it) }


        client =
            activity?.let { retrofitClient(it)?.create(Api::class.java) }
        protectMeasure()
    }


    fun protectMeasure() {

        kProgressHUD?.show()
        client?.PopularQuestionList()
            ?.enqueue(object : Callback<List<ProtectMeasureModel?>?> {
                override fun onResponse(
                    call: Call<List<ProtectMeasureModel?>?>,
                    response: Response<List<ProtectMeasureModel?>?>
                ) {
                    if (response.isSuccessful) {
                        Log.e("TAG", "isSuccessful")
                        kProgressHUD?.dismiss()
                        protectMeasureAdapter =
                            activity?.let {
                                ProtectMeasureAdapter(
                                    it,
                                    response.body() as List<ProtectMeasureModel>
                                )
                            }
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

                    activity?.toast(getString(R.string.error))
                }
            })
    }

    override fun onResume() {
        super.onResume()
        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.faq),2)

    }
}