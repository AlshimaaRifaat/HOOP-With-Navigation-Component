package com.ibsvalley.hoop.view.fragment.test

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.ibsvalley.hoop.*
import com.ibsvalley.hoop.model.QuestionnaireSumitQuestionsModel

import com.ibsvalley.hoop.view.activity.NAVHomeActivity
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.activity_test_result.*
import java.util.*


class TestResultFragment : Fragment(R.layout.activity_test_result) {


    private var kProgressHUD: KProgressHUD? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        kProgressHUD = getKProgressHUD(requireContext())

//

        var lang_code: String =
            activity?.getSharedPreferences("userData", Context.MODE_PRIVATE)
                ?.getString("mlang", Locale.getDefault().language)
                .toString()
        activity?.let { ContextWrapper.setLocale(it, lang_code) }

        NAVHomeActivity.Flag="AAAAAAAA"
        NAVHomeActivity.FlagHereActivity =""

        arguments?.let {
            val safeArgs =
                TestResultFragmentArgs.fromBundle(
                    it
                )


            val gson = Gson()

            val obj: QuestionnaireSumitQuestionsModel? =
                gson.fromJson<QuestionnaireSumitQuestionsModel>(
                    safeArgs.testResultOb,
                    QuestionnaireSumitQuestionsModel::class.java
                )

            val Test_Result = obj?.testResult
            val Result_Fla = obj?.resultFlag




            when (Result_Fla) {
                1 -> {

                    circleImg.setBackgroundColor(Color.parseColor("#8D2D2D"))
                    circleImg.setImageResource(R.drawable.positive)
//                appbar.setBackgroundColor(Color.parseColor("#8D2D2D"))
                    parentConstraintlayout.setBackgroundColor(Color.parseColor("#8D2D2D"))
                    T_maybe.text = getString(R.string.positive)
                    date.text = Test_Result


                }
                0 -> {

                    circleImg.setBackgroundColor(Color.parseColor("#CDA900"))
                    circleImg.setImageResource(R.drawable.may)
//                appbar.setBackgroundColor(Color.parseColor("#CDA900"))
                    parentConstraintlayout.setBackgroundColor(Color.parseColor("#CDA900"))
                    T_maybe.text = getString(R.string.maybe)
                    date.text = Test_Result

                }
                -1 -> {

                    circleImg.setBackgroundColor(Color.parseColor("#43630C"))
                    circleImg.setImageResource(R.drawable.negative)
//                appbar.setBackgroundColor(Color.parseColor("#43630C"))
                    parentConstraintlayout.setBackgroundColor(Color.parseColor("#43630C"))
                    T_maybe.text = getString(R.string.negative)
                    date.text = Test_Result

                }
            }
//
            register.setOnClickListener {
                            activity?.finishAffinity()
                activity?.goTo(NAVHomeActivity())

            }

        }


    }
}



