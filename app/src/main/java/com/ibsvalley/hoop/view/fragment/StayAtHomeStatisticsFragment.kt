package com.ibsvalley.hoop.view.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.Fragment
import com.ibsvalley.hoop.ContextWrapper
import com.ibsvalley.hoop.R
import com.ibsvalley.hoop.getKProgressHUD
import com.ibsvalley.hoop.model.EgyptStatisticsModel
import com.ibsvalley.hoop.model.StayAtHomeStatisticsModel
import com.ibsvalley.hoop.model.SubmitAtHomeQuestionModel
import com.ibsvalley.hoop.network.Api
import com.ibsvalley.hoop.network.ApiClient.retrofitService
import com.ibsvalley.hoop.network.retrofitClient
import com.ibsvalley.hoop.toast
import com.ibsvalley.hoop.view.activity.NAVHomeActivity
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.activity_stay_at_home_statistics.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class StayAtHomeStatisticsFragment : Fragment(R.layout.activity_stay_at_home_statistics) {

    private var dataSaver: SharedPreferences? = null
    private var kProgressHUD: KProgressHUD? = null
    private var DeviceId: String = ""
    private var dateFomDevice: String = ""

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dataSaver = activity?.let { PreferenceManager.getDefaultSharedPreferences(it) }
        (context as NAVHomeActivity).setActionBarTitle(
            context?.getString(R.string.stay_at_home1),
            2
        )
        NAVHomeActivity.FlagHereActivity = ""
        var lang_code: String =
            activity?.getSharedPreferences("userData", Context.MODE_PRIVATE)
                ?.getString("mlang", Locale.getDefault().language)
                .toString()
        activity?.let { ContextWrapper.setLocale(it, lang_code) }
        kProgressHUD = activity?.let { getKProgressHUD(it) }

        @SuppressLint("HardwareIds") val android_id =
            Settings.Secure.getString(
                activity?.contentResolver,
                Settings.Secure.ANDROID_ID
            )
        Log.i("DeviceId", android_id)
        DeviceId = android_id


        btn_in.setOnClickListener {

            btn_in.setBackgroundResource(R.drawable.btn_out)
            btn_out.setBackgroundResource(R.drawable.btn_in)

            btn_in.isClickable = false
            btn_out.isClickable = true

            dataSaver?.edit()
                ?.putInt("isClickable", 1)?.apply()
            getSubmitAtHomeQuestionValues(DeviceId, "in", 1)

        }

        btn_out.setOnClickListener {
            btn_in.setBackgroundResource(R.drawable.btn_in)
            btn_out.setBackgroundResource(R.drawable.btn_out)
            btn_out.isClickable = false
            btn_in.isClickable = true
            getSubmitAtHomeQuestionValues(DeviceId, "out", 2)


            dataSaver?.edit()
                ?.putInt("isClickable", 2)?.apply()


        }
        val clickable = dataSaver?.getInt("isClickable", 0)
        when (clickable) {

            1 -> {
                Log.i("AAAAAAAA", ""+2)


                btn_in.setBackgroundResource(R.drawable.btn_out)
                btn_in.isClickable = false

            }


            2 -> {
                Log.i("AAAAAAAA", ""+1)

                btn_out.setBackgroundResource(R.drawable.btn_out)

                btn_out!!.isEnabled = false


            }

        }




        getEgyptStatisticsValues()
        getStayAtHomeStatisticsValues()
    }


    private fun getStayAtHomeStatisticsValues() {

        val call = retrofitClient(requireContext())?.create(Api::class.java)
            ?.stayAtHomeStatistics()
        call?.enqueue(object : Callback<StayAtHomeStatisticsModel> {
            override fun onResponse(
                call: Call<StayAtHomeStatisticsModel>,
                response: Response<StayAtHomeStatisticsModel>
            ) {

                //                kProgressHUD?.dismiss()

                if (response.code() == 200) {
                    val numOfDays = dataSaver?.getString("numOfDays", "")
                    val daysDevice = dataSaver?.getString("daysDevice", "")
                    dateFomDevice =
                        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())




                    if (dataSaver?.getString(
                            "daysDeviceF",
                            ""
                        )!! > dateFomDevice && dataSaver?.getString(
                            "daysDeviceS",
                            ""
                        )!! > dateFomDevice
                        && dataSaver?.getString(
                            "numOfDays",
                            ""
                        )!! < response.body()?.numOfDays.toString()
                    ) {

                        dataSaver?.edit()
                            ?.putString("daysDeviceF", dateFomDevice)?.apply()
                        dataSaver?.edit()
                            ?.putString("daysDeviceS", dateFomDevice)?.apply()


                        btn_out.isClickable = true

                        btn_in.isClickable = true
                    }
                    dataSaver?.edit()
                        ?.putString(
                            "numOfDays",
                            response.body()?.numOfDays.toString()
                        )?.apply()





                    T_daysNum.text = response.body()?.numOfDays.toString()
                    T_in.text = response.body()?.iNHome.toString()
                    T_out.text = response.body()?.oUTHome.toString()

                } else {

                }
            }

            override fun onFailure(call: Call<StayAtHomeStatisticsModel>, t: Throwable) {
                //                kProgressHUD?.dismiss()

            }
        })
    }

    private fun getEgyptStatisticsValues() {

        kProgressHUD?.show()


        val call = retrofitService
            ?.egyptStatistics("EG")
        call?.enqueue(object : Callback<EgyptStatisticsModel> {
            override fun onResponse(
                call: Call<EgyptStatisticsModel>,
                response: Response<EgyptStatisticsModel>
            ) {

                if (response.code() == 200) {


                    kProgressHUD?.dismiss()
                    dataSaver = PreferenceManager.getDefaultSharedPreferences(requireContext())

                    dataSaver?.edit()
                        ?.putString(
                            "totalCases",
                            response.body()?.countrydata?.get(0)?.totalCases.toString()
                        )
                        ?.apply()
                    dataSaver?.edit()
                        ?.putString(
                            "totalRecovered",
                            response.body()?.countrydata?.get(0)?.totalRecovered.toString()
                        )
                        ?.apply()
                    dataSaver?.edit()
                        ?.putString(
                            "totalDeaths",
                            response.body()?.countrydata?.get(0)?.totalDeaths.toString()
                        )
                        ?.apply()

                    T_infected_number.text =
                        response.body()?.countrydata?.get(0)?.totalCases.toString()
                    T_recovered_number.text =
                        response.body()?.countrydata?.get(0)?.totalRecovered.toString()
                    T_died_number.text =
                        response.body()?.countrydata?.get(0)?.totalDeaths.toString()

                } else {
                    kProgressHUD?.dismiss()
//
                    dataSaver = PreferenceManager.getDefaultSharedPreferences(requireContext())

                    T_infected_number.text = dataSaver?.getString("totalCases", "")
                    T_recovered_number.text = dataSaver?.getString("totalRecovered", "")
                    T_died_number.text = dataSaver?.getString("totalDeaths", "")


                }
            }

            override fun onFailure(call: Call<EgyptStatisticsModel>, t: Throwable) {
                kProgressHUD?.dismiss()
                dataSaver = PreferenceManager.getDefaultSharedPreferences(requireContext())

                T_infected_number.text = dataSaver?.getString("totalCases", "")
                T_recovered_number.text = dataSaver?.getString("totalRecovered", "")
                T_died_number.text = dataSaver?.getString("totalDeaths", "")
            }
        })
    }

    private fun getSubmitAtHomeQuestionValues(deviceName: String, choice: String, num: Int) {

        kProgressHUD?.show()
        val call = retrofitClient(requireContext())?.create(Api::class.java)
            ?.submitAtHomeQuestion(deviceName, choice)
        call?.enqueue(object : Callback<SubmitAtHomeQuestionModel> {
            override fun onResponse(
                call: Call<SubmitAtHomeQuestionModel>,
                response: Response<SubmitAtHomeQuestionModel>
            ) {

                kProgressHUD?.dismiss()
                if (response.code() == 200) {

                    if (num == 1) {

                        dataSaver?.edit()
                            ?.putInt("in", 15)?.apply()

                    } else {
                        dataSaver?.edit()
                            ?.putInt("Out", 15)?.apply()
                    }


                    T_in.text = response.body()?.iNHome.toString()
                    T_out.text = response.body()?.oUTHome.toString()

                    response.body()?.userMessage?.let { activity?.toast(it) }
                }

            }

            override fun onFailure(call: Call<SubmitAtHomeQuestionModel>, t: Throwable) {
                kProgressHUD?.dismiss()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        (context as NAVHomeActivity).setActionBarTitle(
            context?.getString(R.string.stay_at_home1),
            2
        )

    }

}