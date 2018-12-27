package com.yakov.weber.businesscart.ui.statistic

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.yakov.weber.businesscart.R
import com.yakov.weber.businesscart.adapter.CardAdapter
import com.yakov.weber.businesscart.ui.global.BaseFragment
import com.yakov.weber.businesscart.view.model.MyViewModel
import kotlinx.android.synthetic.main.fragment_statistic.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created on 19.12.18
 * @author YWeber
 * project BusinessCart */

class StatisticFragment : BaseFragment() {

    override val layoutRes: Int
        get() = R.layout.fragment_statistic


    private val viewModel by lazy {ViewModelProviders.of(this).get(MyViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDialog(true)
        viewModel.getData().observe(this, Observer { list ->
            card_recycler_static.adapter = CardAdapter(list!!) { _, card -> viewModel.getToastText()
                ?.observe(this, Observer {
                    it?.let { it1 -> toast(it1) }
                }) }
            card_recycler_static.layoutManager = LinearLayoutManager(activity)
            showDialog(false)
        })

    }
}