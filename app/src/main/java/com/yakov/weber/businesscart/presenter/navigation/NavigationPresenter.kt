package com.yakov.weber.businesscart.presenter.navigation

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.businesscart.Screens
import com.yakov.weber.businesscart.presenter.global.BasePresenter
import com.yakov.weber.businesscart.system.FlowRouter
import com.yakov.weber.businesscart.system.ResourceManager
import com.yakov.weber.businesscart.system.message.SystemMessageNotifier
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created on 13.12.18
 * @author YWeber
 * project BusinessCart */
@InjectViewState
class NavigationPresenter @Inject constructor(private val flowRouter: FlowRouter) : BasePresenter<NavigationView>() {

    fun openReadyFlow() = flowRouter.startFlow(Screens.ReadyFlow)
    fun goToStatisticFlow() = flowRouter.startFlow(Screens.StatisticFlow)
    fun goToDraftFlow() = flowRouter.startFlow(Screens.DraftFlow)
}