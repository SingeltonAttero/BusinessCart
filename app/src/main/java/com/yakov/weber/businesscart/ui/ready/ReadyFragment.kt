package com.yakov.weber.businesscart.ui.ready

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.yakov.weber.businesscart.R
import com.yakov.weber.businesscart.Screens
import com.yakov.weber.businesscart.entity.BusinessCard
import com.yakov.weber.businesscart.model.MockData
import com.yakov.weber.businesscart.ui.global.BaseFragment
import com.yakov.weber.businesscart.adapter.CardAdapter
import kotlinx.android.synthetic.main.fragment_ready.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created on 13.12.18
 * @author YWeber
 * project BusinessCart */

class ReadyFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_ready

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        card_recycler.adapter = CardAdapter(MockData.newInstance()) { position, card -> toast(card.toString()) }
        card_recycler.layoutManager = LinearLayoutManager(activity)
        fab.setOnClickListener { startActivity(Screens.BuildCartScreen.getActivityIntent(activity))}

    }

    private fun dataBus(list: List<BusinessCard>): LiveData<String>? {
        val mutableLiveData = MutableLiveData<String>()
        mutableLiveData.value = list.last().email
        return mutableLiveData
    }
}