package com.aykutpullu.multicampandroidassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aykutpullu.multicampandroidassignment.model.DeveloperGroup

class DetailCommunityViewModel :ViewModel() {

    val gdcGroups = MutableLiveData<List<DeveloperGroup>>()


}