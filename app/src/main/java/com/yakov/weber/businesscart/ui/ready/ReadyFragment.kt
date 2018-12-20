package com.yakov.weber.businesscart.ui.ready

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.yakov.weber.businesscart.R
import com.yakov.weber.businesscart.model.MockData
import com.yakov.weber.businesscart.ui.global.BaseFragment
import com.yakov.weber.businesscart.ui.ready.adapter.CardAdapter
import kotlinx.android.synthetic.main.fragment_ready.*
import org.jetbrains.anko.support.v4.act
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
    }
}