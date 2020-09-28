package com.aykutpullu.multicampandroidassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aykutpullu.multicampandroidassignment.model.DeveloperGroup
import com.aykutpullu.multicampandroidassignment.service.gdcAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CommunityViewModel : ViewModel() {

    private val gdcApiservice = gdcAPIService()
    private val disposable = CompositeDisposable()

    val gdcGroups = MutableLiveData<List<DeveloperGroup>>()

    fun refreshData() {
        getDataFromAPI()
    }


    private fun getDataFromAPI () {

        disposable.add(
            gdcApiservice.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<DeveloperGroup>>(){
                    override fun onSuccess(t: List<DeveloperGroup>) {
                        gdcGroups.value = t
                        println("veri çekildi")


                    }

                    override fun onError(e: Throwable) {

                        println("veri çekilemedi")
                        e.printStackTrace()

                    }


                })

        )

    }


}