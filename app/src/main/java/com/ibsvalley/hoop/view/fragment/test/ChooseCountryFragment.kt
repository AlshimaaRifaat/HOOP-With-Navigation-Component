package com.ibsvalley.hoop.view.fragment.test

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ibsvalley.hoop.*
import com.ibsvalley.hoop.model.CountryListModel
import com.ibsvalley.hoop.network.Api
import com.ibsvalley.hoop.network.retrofitClient
import com.ibsvalley.hoop.view.activity.NAVHomeActivity
import com.ibsvalley.hoop.view.fragment.HomeFragmentDirections

import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.activity_choose_country.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ChooseCountryFragment : Fragment(R.layout.activity_choose_country) {

    private var dataSaver: SharedPreferences? = null
    private var kProgressHUD: KProgressHUD? = null
    private var client: Api? = null
    private var MainCats_name: MutableList<String> = mutableListOf()
    private var MainCats_IDs: MutableList<String> = mutableListOf()
    private var SubCats_IDs: MutableList<String> = mutableListOf()
    private var SubCats_name: MutableList<String> = mutableListOf()

    private lateinit var s: String
    private lateinit var Cites: String
    private lateinit var subCatID: String


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var lang_code: String =
            activity?.getSharedPreferences("userData", Context.MODE_PRIVATE)
                ?.getString("mlang", Locale.getDefault().language)
                .toString()
        activity?.let { ContextWrapper.setLocale(it, lang_code) }
        NAVHomeActivity.FlagHereActivity =""



        kProgressHUD = getKProgressHUD(requireContext())


        client =
            retrofitClient(requireContext())?.create(Api::class.java)

        countrySp.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View,
                i: Int,
                l: Long
            ) {
                val provName: String = countrySp.selectedItem.toString()
                if (!MainCats_IDs.isEmpty()) {
                    s = MainCats_IDs[i]

                    if (i == 0) {
                        citySp.setEnabled(false)
                        SubCats_name.clear()
                        SubCats_IDs.clear()
                        SubCats_IDs.add("")
                        SubCats_name.add(getString(R.string.select_city))
                        val spinnerArrayAdapter =

                            ArrayAdapter(
                                requireContext(),
                                R.layout.spinner_view_stamp,
                                SubCats_name
                            )

                        citySp.setAdapter(spinnerArrayAdapter)
                    } else if (i != 0) {
                        citySp.isEnabled = true
                        kProgressHUD?.show()

                        GetSubCate(s)
                    }
                } else {
                    Log.i("No Cities", "لا يوجد مناطق")
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }



        citySp.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View,
                i: Int,
                l: Long
            ) {
                val s: String = citySp.selectedItem.toString()
                Log.i("AreaName", s)
                if (SubCats_IDs.size != 0) {
                    subCatID = SubCats_IDs[i]
                    Cites = SubCats_name[i]
                    Log.i("AreaID2", Cites)
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }


        SubCats_IDs.add("")
        SubCats_name.add(getString(R.string.select_country))
        val spinnerArrayAdapter =
            ArrayAdapter(requireContext(), R.layout.spinner_view_stamp, SubCats_name)
        citySp.setAdapter(spinnerArrayAdapter)
        GetMainCat()


        continuee.setOnClickListener {
            if (subCatID.isEmpty() || s.isEmpty() || countrySp.selectedItemPosition == 0 || citySp.selectedItemPosition == 0) {

                activity?.toast(getString(R.string.you_must_selected_country_and_city))
            } else {

                dataSaver = PreferenceManager.getDefaultSharedPreferences(requireContext())

                dataSaver?.edit()
                    ?.putInt("counrty", s.toInt())?.apply()

                dataSaver?.edit()
                    ?.putInt("city", subCatID.toInt())?.apply()

                val nextAction =ChooseCountryFragmentDirections.actionChooseCountryFragmentToUserInFragment()
                Navigation.findNavController(it).navigate(nextAction)

            }


        }
    }


    private fun GetMainCat() {

        kProgressHUD?.show()

        client?.country()?.enqueue(object : Callback<CountryListModel> {
            override fun onFailure(call: Call<CountryListModel>, t: Throwable) {
                activity?.toast(getString(R.string.select_country))
                kProgressHUD?.dismiss()
            }

            override fun onResponse(
                call: Call<CountryListModel>,
                response: Response<CountryListModel>
            ) {
                kProgressHUD?.dismiss()

                assert(response.body() != null)
                if (response.body()!!.size != 0) {
                    val cityName: String = response.body()!![0].name
                    Log.i("ProvincesName", cityName)
                    MainCats_name = ArrayList()
                    MainCats_IDs = ArrayList()
                    MainCats_name.clear()
                    MainCats_IDs.clear()
                    MainCats_IDs.add("")
                    MainCats_name.add(getString(R.string.select_country))
                    for (i in response.body()!!.indices) {
                        MainCats_name.add(response.body()!![i].name)
                        MainCats_IDs.add(response.body()!![i].id.toString())
                    }
                    val spinnerArrayAdapter =

                        ArrayAdapter(
                            requireContext(),
                            R.layout.spinner_view_stamp,
                            MainCats_name
                        )
                    //selected item will look like a spinner set from XML
                    countrySp.setAdapter(spinnerArrayAdapter)
                    Log.i("Governments", countrySp.toString())
                } else {
                    MainCats_name.clear()
                    MainCats_name.add(getString(R.string.no_country))
                    val spinnerArrayAdapter =

                        ArrayAdapter(
                            requireContext(),
                            R.layout.spinner_view_stamp,
                            MainCats_name
                        )

                    countrySp.adapter = spinnerArrayAdapter

                }

            }
        })


    }

    private fun GetSubCate(id: String) {

        client?.city(id.toInt())?.enqueue(object : Callback<CountryListModel> {
            override fun onFailure(call: Call<CountryListModel>, t: Throwable) {
                activity?.toast(getString(R.string.error))
                kProgressHUD?.dismiss()

            }

            override fun onResponse(
                call: Call<CountryListModel>,
                response: Response<CountryListModel>
            ) {
                kProgressHUD?.dismiss()

                SubCats_name.clear()
                SubCats_IDs.clear()
                SubCats_name.add(getString(R.string.select_city))
                SubCats_IDs.add("")
                if (response.isSuccessful) {
                    assert(response.body() != null)
                    if (response.body()!!.size != 0) {
                        for (i in response.body()!!.indices) {
                            SubCats_name.add(response.body()!![i].name)
                            SubCats_IDs.add(response.body()!![i].id.toString())
                        }
                        val spinnerArrayAdapter =

                            ArrayAdapter(
                                requireContext(),
                                R.layout.spinner_view_stamp,
                                SubCats_name
                            )
                        citySp.adapter = spinnerArrayAdapter
                        Log.i("City", SubCats_name.toString())
                        kProgressHUD?.dismiss()
                    } else {
                        SubCats_name.clear()
                        SubCats_name.add(getString(R.string.no_city))
                        val spinnerArrayAdapter =

                            activity?.let {
                                ArrayAdapter(
                                    it,
                                    R.layout.spinner_view_stamp,
                                    SubCats_name

                                )
                            }

                        citySp.adapter = spinnerArrayAdapter
                    }
                }
            }
        })

    }


}

