package com.ibsvalley.hoop.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ibsvalley.hoop.*
import com.ibsvalley.hoop.model.HomeIsolationModel
import com.ibsvalley.hoop.network.Api
import com.ibsvalley.hoop.network.retrofitClient
import com.ibsvalley.hoop.view.activity.NAVHomeActivity

import com.ibsvalley.hoop.view.adapter.HomeIsolationAdapter
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.activity_home_isolation2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class HomeIsolationFragment : Fragment(R.layout.activity_home_isolation2){

    private var kProgressHUD: KProgressHUD? = null
    private var client: Api? = null

    var layoutManager: GridLayoutManager? = null
    var homeIsolationAdapter: HomeIsolationAdapter? = null
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
    homeIsolation()
    }

    fun homeIsolation(){
        kProgressHUD?.show()
            Log.e("TAG", "isSuccessful")
            client?.homeIsolation()
                ?.enqueue(object : Callback<List<HomeIsolationModel?>?> {
                    override fun onResponse(
                        call: Call<List<HomeIsolationModel?>?>,
                        response: Response<List<HomeIsolationModel?>?>
                    ) {
                        if (response.isSuccessful) {
                            Log.e("TAG", "isSuccessful")
                            kProgressHUD?.dismiss()
                            homeIsolationAdapter =
                                activity?.let {
                                    HomeIsolationAdapter(
                                        it,
                                        response.body() as List<HomeIsolationModel>
                                    )
                                }
                            home_isolation_recycler!!.adapter = homeIsolationAdapter
                        } else {
                            kProgressHUD?.dismiss()
                            Log.e("TAG", "notSuccessful")
                        }
                    }

                    override fun onFailure(
                        call: Call<List<HomeIsolationModel?>?>,
                        t: Throwable
                    ) {
                        Log.e("TAG ", "onFailure")
                        kProgressHUD?.dismiss()

                        activity?.toast(getString(R.string.error))
                    }
                })
        }



}