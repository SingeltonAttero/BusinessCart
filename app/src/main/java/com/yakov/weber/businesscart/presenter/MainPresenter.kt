package com.yakov.weber.businesscart.presenter

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.businesscart.R
import com.yakov.weber.businesscart.Screens
import com.yakov.weber.businesscart.extension.printConstruction
import com.yakov.weber.businesscart.presenter.global.BasePresenter
import com.yakov.weber.businesscart.system.ResourceManager
import com.yakov.weber.businesscart.system.message.SystemMessageNotifier
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */
@InjectViewState
class MainPresenter @Inject constructor (private val systemMessage: SystemMessageNotifier,
                                         private val resourceManager: ResourceManager,
                                         private val router: Router) : BasePresenter<MainView>() {
    init {
        printConstruction()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.NavigationMenuFlow)
    }
}