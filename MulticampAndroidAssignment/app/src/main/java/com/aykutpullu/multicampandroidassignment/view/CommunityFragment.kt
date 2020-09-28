package com.aykutpullu.multicampandroidassignment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.aykutpullu.multicampandroidassignment.R
import com.aykutpullu.multicampandroidassignment.adapter.GdcAdapter
import com.aykutpullu.multicampandroidassignment.viewmodel.CommunityViewModel
import kotlinx.android.synthetic.main.fragment_community.*


class CommunityFragment : Fragment() {


    private var obsNum = 0
    private lateinit var viewModel : CommunityViewModel
    private val gdcAdapter = GdcAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProviders.of(this).get(CommunityViewModel::class.java)
        viewModel.refreshData()
        communityRecView.adapter=gdcAdapter

        if (obsNum ==0)
        {
            observeLiveData()
            obsNum++
        }


        println("onviewcreate cağırıldı")

    }


    private fun observeLiveData() {

        viewModel.gdcGroups.observe(viewLifecycleOwner,{
            groups -> groups?.let {

            communityRecView.visibility = View.VISIBLE
            gdcAdapter.updateGdcList(groups)
        }
        })


    }


}

