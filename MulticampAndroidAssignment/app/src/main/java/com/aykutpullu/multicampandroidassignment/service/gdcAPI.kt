package com.aykutpullu.multicampandroidassignment.service

import com.aykutpullu.multicampandroidassignment.model.DeveloperGroup
import io.reactivex.Single
import retrofit2.http.GET

interface gdcAPI {

    // https://5f6642a143662800168e7538.mockapi.io/multicamp/communities

    @GET ("multicamp/communities")
    fun getGdc() : Single<List<DeveloperGroup>>
}