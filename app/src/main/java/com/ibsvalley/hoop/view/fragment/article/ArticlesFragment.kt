package com.ibsvalley.hoop.view.fragment.article

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ibsvalley.hoop.ContextWrapper
import com.ibsvalley.hoop.R
import com.ibsvalley.hoop.getKProgressHUD
import com.ibsvalley.hoop.network.ArticlesListCall
import com.ibsvalley.hoop.toast
import com.ibsvalley.hoop.view.activity.NAVHomeActivity
import com.ibsvalley.hoop.view.activity.NAVHomeActivity.Companion.FlagHereActivity
import com.ibsvalley.hoop.view.adapter.ArticlesListAdapter
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.activity_articles.*
import java.util.*


class ArticlesFragment :Fragment(R.layout.activity_articles) {

    private var kProgressHUD: KProgressHUD? = null


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        FlagHereActivity=""
           kProgressHUD = getKProgressHUD(requireContext())
        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.articles),2)

        var lang_code: String =
            activity?.getSharedPreferences("userData", Context.MODE_PRIVATE)
                ?.getString("mlang", Locale.getDefault().language)
                .toString()
        activity?.let { ContextWrapper.setLocale(it, lang_code) }
//        val TITLE = intent?.extras?.getString(Constants.DEST)
//        TitleTool.text=TITLE

        val navHomeActivity =
            NAVHomeActivity()
        displayArticleData()


    }



    private fun displayArticleData() {
        kProgressHUD?.show()

        ArticlesListCall.getArticlesListApi(requireContext(), {
            kProgressHUD?.dismiss()


            rcArticlesList.apply {
                adapter = ArticlesListAdapter(it)
                { item ->

                }
            }
        }, {
            kProgressHUD?.dismiss()
            activity?.toast(getString(R.string.error))
        })
    }

    override fun onResume() {
        super.onResume()
        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.articles),2)

    }
}