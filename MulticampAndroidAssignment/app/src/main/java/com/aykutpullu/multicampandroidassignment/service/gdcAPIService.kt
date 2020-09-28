package com.aykutpullu.multicampandroidassignment.service

import com.aykutpullu.multicampandroidassignment.model.DeveloperGroup
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class gdcAPIService {

    //https://5f6642a143662800168e7538.mockapi.io/multicamp/communities

    private val BASE_URL = "https://5f6642a143662800168e7538.mockapi.io/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(gdcAPI::class.java)

    fun getData():Single<List<DeveloperGroup>> {
        return api.getGdc()
    }
}