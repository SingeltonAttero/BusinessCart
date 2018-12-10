package com.yakov.weber.businesscart.presenter

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.businesscart.R
import com.yakov.weber.businesscart.extension.printConstruction
import com.yakov.weber.businesscart.presenter.global.BasePresenter
import com.yakov.weber.businesscart.system.ResourceManager
import com.yakov.weber.businesscart.system.message.SystemMessageNotifier
import javax.inject.Inject

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */
@InjectViewState
class MainPresenter @Inject constructor (private val systemMessage: SystemMessageNotifier,
                                         private val resourceManager: ResourceManager) : BasePresenter<MainView>() {
    init {
        printConstruction()
    }

    fun test() = systemMessage.systemMessage(resourceManager.getString(R.string.app_name))
}