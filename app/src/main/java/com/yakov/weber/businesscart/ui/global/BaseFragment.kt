package com.yakov.weber.businesscart.ui.global

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.yakov.weber.businesscart.system.disposable.ComponentDisposableBind
import com.yakov.weber.businesscart.system.disposable.ComponentDisposableBindImpl
import com.yakov.weber.businesscart.ui.MainActivity

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */

abstract class BaseFragment : MvpAppCompatFragment(),ComponentDisposableBind by ComponentDisposableBindImpl(){

    abstract val layoutRes: Int @LayoutRes get

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes,container,false)
    }

    fun setToolbar(toolbar:Toolbar,title:String = ""){
        val mainActivity = activity as MainActivity
        toolbar.title = title
        mainActivity.setToolbar(toolbar)
    }

    override fun onDestroy() {
        clear()
        super.onDestroy()
    }
}