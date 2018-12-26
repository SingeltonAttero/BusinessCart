package com.yakov.weber.businesscart.model

import android.arch.lifecycle.MutableLiveData
import com.yakov.weber.businesscart.entity.BusinessCard

/**
 * Created on 25.12.18
 * @author YWeber
 * project BusinessCart */

object LiveDataList  {
    private val liveData:MutableLiveData<List<BusinessCard>> = MutableLiveData()
    fun getData(): MutableLiveData<List<BusinessCard>> {
        liveData.value = MockData.newInstance()
        return liveData
    }
}