package com.yakov.weber.businesscart.view.model

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.yakov.weber.businesscart.R
import com.yakov.weber.businesscart.entity.BusinessCard
import com.yakov.weber.businesscart.model.MockData
import com.yakov.weber.businesscart.system.ResourceManager
import com.yakov.weber.businesscart.toothpick.DI
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import toothpick.Toothpick
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.random.Random

/**
 * Created on 26.12.18
 * @author YWeber
 * project BusinessCart */

class MyViewModel constructor() : ViewModel() {

    init {
        Toothpick.inject(this, Toothpick.openScope(DI.APP_SCOPE))
    }
    private val repositoryMock = Single.fromCallable {
        MockData.newInstance()
    }.delay(3000,TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.io())

    private var data:MutableLiveData<MutableList<BusinessCard>>? = null
    private var toastContent:MutableLiveData<String>? = null

    fun getToastText(): LiveData<String>? {
        if (toastContent == null){
            toastContent = MutableLiveData()
            toastContent?.value = "test"
        }
        return toastContent
    }

    fun getData(): LiveData<MutableList<BusinessCard>> {
        if (data == null){
            data = MutableLiveData()
            loadData()
        }
        return data as MutableLiveData<MutableList<BusinessCard>>
    }

    @SuppressLint("CheckResult")
    fun loadData(){
        repositoryMock.subscribe({
            data?.postValue(it)
        },{
            Timber.e(it)
        })
    }



}