package com.ibsvalley.hoop.view.fragment.test

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.gson.Gson
import com.ibsvalley.hoop.*
import com.ibsvalley.hoop.model.QuestionnaireSumitQuestionsModel
import com.ibsvalley.hoop.network.Api
import com.ibsvalley.hoop.network.QuestionnaireCall
import com.ibsvalley.hoop.network.retrofitClient
import com.ibsvalley.hoop.view.activity.NAVHomeActivity

import com.ibsvalley.hoop.view.adapter.ParentOvalAdapter
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.fragment_user_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class UserInFragment : Fragment(R.layout.fragment_user_info), AdapterView.OnItemSelectedListener {
    private var dataSaver: SharedPreferences? = null
    private var size: Int = 0
    private lateinit var DeviceId: String
    private lateinit var list: MutableList<String>
    private lateinit var list_of_items: Array<String>
    private var kProgressHUD: KProgressHUD? = null
    private var city = 0
    private var counrty = 0
    var String1: String = ""

    private var gender_SelectedItemSpinner: String = ""


    private var client: Api? = null
    var gender_id: String? = null


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        NAVHomeActivity.FlagHereActivity =""
        var lang_code: String =
            activity?.getSharedPreferences("userData", Context.MODE_PRIVATE)
                ?.getString("mlang", Locale.getDefault().language)
                .toString()
        activity?.let { ContextWrapper.setLocale(it, lang_code) }

        @SuppressLint("HardwareIds") val android_id =
            Settings.Secure.getString(
                activity?.contentResolver,
                Settings.Secure.ANDROID_ID
            )
        Log.i("DeviceId", android_id)
        DeviceId = android_id
        list_of_items = arrayOf(
            getString(R.string.select_gender),
            getString(R.string.male), getString(R.string.female)
        )

        kProgressHUD = activity?.let { getKProgressHUD(it) }
//        counrty = intent?.extras?.getInt("counrty", 0)!!
//        city = intent?.extras?.getInt("city", 0)!!
        dataSaver = PreferenceManager.getDefaultSharedPreferences(requireContext())

        val counrty = dataSaver?.getInt("counrty", 0)
        val city = dataSaver?.getInt("city", 0)


        getGenderSpinnerItems()

        phone.setOnClickListener {
            phone.text.clear()
        }
        continueRe.setOnClickListener {
            validateInputs(it)


        }

        displayQuestionnaireData()

    }

    private fun validateInputs(it: View) {
        if (name?.text.toString().isNotEmpty() &&
            phone.text.toString().isNotEmpty()
            && age.text.toString().isNotEmpty() &&
            gender_SelectedItemSpinner != "Gender"

        ) {
            //validate username
            //validate username
            if (Utils.validateName(name?.text.toString())) {

                if (Utils.validatePhone(phone?.text.toString())) {
                    //attempt signup here

                    list = mutableListOf()
                    val ids: HashMap<Int, Int> =
                        Selection_Multi_Selected1.selection_multi_selected().ids
                    if (ids.isNotEmpty() && ids.size == size) {


                        for (key in ids.keys) {
                            println("$key = ${ids[key]}")
                            String1 = "$key = ${ids[key]}"
                            list.add(String1)

                        }

                        GetMainCat(it)


                    } else {
                        activity?.toast(getString(R.string.you_must_answer_for_these_question))
                    }


                } else {
                    //invalid phone number

                    phone.error = getString(R.string.invalid_phone)
                    phone.requestFocus()


                }


            } else {

                //invalid username
                name.error = getString(R.string.invalid_username)
                name.requestFocus()


            }
        } else {
            // fill inputs
            activity?.toast(getString(R.string.fill_inputs))
            Log.d("asdsadsadsa", "")
        }
    }


    private fun GetMainCat(it1: View) {

        Log.i("asdsadsadsa", "toName$list")


        kProgressHUD
            ?.show()


        activity?.let {
            retrofitClient(it)?.create(Api::class.java)?.SumitQuestions(
                name.text.toString(),
                phone.text.toString(),
                counrty,
                city,
                age.text.toString().toInt(),
                gender_SelectedItemSpinner,
                list.toString(), DeviceId
            )
                ?.enqueue(object : Callback<QuestionnaireSumitQuestionsModel?> {
                    //

                    override fun onFailure(
                        call: Call<QuestionnaireSumitQuestionsModel?>,
                        t: Throwable
                    ) {
                        activity?.toast(getString(R.string.error))
                        kProgressHUD
                            ?.dismiss()
                    }

                    override fun onResponse(
                        call: Call<QuestionnaireSumitQuestionsModel?>,
                        response: Response<QuestionnaireSumitQuestionsModel?>
                    ) {
                        kProgressHUD
                            ?.dismiss()
                        if (response.isSuccessful) {


                            val gson = Gson();
                            val myJson = gson.toJson(response.body());

                            Log.d("asdsad", "" + myJson)

//
//                            startActivity(
//                                Intent(
//                                    this@UserInFragment,
//                                    TestResultFragment::class.java
//                                ).apply {
//                                    putExtra("myjson", myJson)
//
//                                })
//                            finishAffinity()

//                            activity!!.findNavController().popBackStack()
                            val nextAction =
                                UserInFragmentDirections.actionUserInFragmentToTestResultFragment()
                            nextAction.testResultOb = myJson
                            Navigation.findNavController(it1)
                                .navigate(nextAction)

//                            findNavController().popBackStack(R.id.userInFragment,false)


                        } else {

                            println("dsadsadsadsafg" + response.message())
                        }
                    }


                })
        }


    }


    private fun displayQuestionnaireData() {
        kProgressHUD?.show()

        QuestionnaireCall.getQuestionnaireApi(requireContext(), {
            kProgressHUD?.dismiss()


            rvQuestionnaire.apply {
                adapter = ParentOvalAdapter(it, requireContext())
                size = it.size

            }
        }, {
            kProgressHUD
                ?.dismiss()
            activity?.toast(getString(R.string.error))
        })
    }

    private fun getGenderSpinnerItems() {
        genderSpinner!!.setOnItemSelectedListener(this)

        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa =
            activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, list_of_items) }
        // Set layout to use when the list of choices appear
        aa?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        genderSpinner!!.adapter = aa

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (genderSpinner.selectedItem === "Gender") {

        } else {
            gender_SelectedItemSpinner = genderSpinner.selectedItem.toString()
        }
    }


}





