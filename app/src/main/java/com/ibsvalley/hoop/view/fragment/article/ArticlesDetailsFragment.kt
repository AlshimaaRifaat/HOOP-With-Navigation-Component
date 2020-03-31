package com.ibsvalley.hoop.view.fragment.article


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ibsvalley.hoop.*
import com.ibsvalley.hoop.ContextWrapper.Companion.setLocale

import com.ibsvalley.hoop.network.ArticlesListIdCall
import com.ibsvalley.hoop.view.activity.NAVHomeActivity
import com.ibsvalley.hoop.view.activity.NAVHomeActivity.Companion.FlagHereActivity
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.activity_articles_details.*
import java.util.*


class ArticlesDetailsFragment : Fragment(R.layout.activity_articles_details) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity= NAVHomeActivity()
//        activity.homeTitleTv?.text =""
    }
    private var kProgressHUD: KProgressHUD? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var lang_code: String =
            activity?.getSharedPreferences("userData", Context.MODE_PRIVATE)
                ?.getString("mlang", Locale.getDefault().language)
                .toString()
        activity?.let { setLocale(it, lang_code) }
        FlagHereActivity=""
        kProgressHUD = getKProgressHUD(requireContext())

        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.article_details),2)

        arguments?.let {
            val safeArgs =
                ArticlesDetailsFragmentArgs.fromBundle(
                    it
                )
            displayArticleDataById(safeArgs.artID.toString())


        }
    }


    private fun displayArticleDataById(dest: String?) {
        kProgressHUD?.show()


        dest?.toInt()?.let {
            ArticlesListIdCall.getArticlesListApi(requireContext(), it, { it1 ->
                kProgressHUD?.dismiss()

                image.loadImage(Constants.IMAGE_BASE_URL + it1[0].Image)
                titleArt.text = it1[0].title


                description.text = it1[0].content

                circleImageView.loadImage(Constants.IMAGE_BASE_URL + it1[0].DoctorImage)
                dName.text = it1[0].author
                dTitle.text = it1[0].authorTitle




                date.text = it1[0].date


            }, {
                kProgressHUD?.dismiss()
                activity?.toast(getString(R.string.error))
            })
        }
    }


}