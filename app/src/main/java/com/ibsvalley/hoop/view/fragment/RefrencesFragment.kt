package com.ibsvalley.hoop.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibsvalley.hoop.ContextWrapper
import com.ibsvalley.hoop.R

import com.ibsvalley.hoop.model.ReferncesModel
import com.ibsvalley.hoop.model.ReferncesViewModel
import com.ibsvalley.hoop.view.activity.NAVHomeActivity
import com.ibsvalley.hoop.view.adapter.RefrencesAdapter
import kotlinx.android.synthetic.main.activity_refrences.*
import java.util.*

class RefrencesFragment :Fragment(R.layout.activity_refrences) {

    lateinit var referncesViewModel: ReferncesViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

            (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.references),2)
        var lang_code: String =
            activity?.getSharedPreferences("userData", Context.MODE_PRIVATE)
                ?.getString("mlang", Locale.getDefault().language)
                .toString()
        activity?.let { ContextWrapper.setLocale(it, lang_code) }
        referncesViewModel =
            ViewModelProvider(this)[ReferncesViewModel::class.java]
        refrencesList()

    }


    private fun refrencesList() {
        referncesViewModel.getRefrencesList(requireContext()).observe(viewLifecycleOwner,
            Observer<List<ReferncesModel>> { referncesModel ->
                if (referncesModel != null) {
                    val  refrencesAdapter = RefrencesAdapter(referncesModel)
                    // listAdapter.onClickItemLatestProduct(this@MainActivity)
                    recyclerRefrences.setLayoutManager(
                        LinearLayoutManager(
                            requireContext()
                        )
                    )
                    recyclerRefrences.setAdapter(refrencesAdapter)

                }
            })
    }


    override fun onResume() {
        super.onResume()
        (context as NAVHomeActivity).setActionBarTitle(context?.getString(R.string.references),2)

    }
}
