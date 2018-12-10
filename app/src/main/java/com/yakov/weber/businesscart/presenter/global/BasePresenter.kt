package com.yakov.weber.businesscart.presenter.global

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.yakov.weber.businesscart.system.disposable.ComponentDisposableBind
import com.yakov.weber.businesscart.system.disposable.ComponentDisposableBindImpl

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */

open class BasePresenter<V : MvpView> : MvpPresenter<V>(), ComponentDisposableBind by ComponentDisposableBindImpl(){
    override fun onDestroy() {
        clear()
        super.onDestroy()
    }
}