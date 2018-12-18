package com.yakov.weber.businesscart.toothpick.module

import com.yakov.weber.businesscart.system.FlowRouter
import com.yakov.weber.businesscart.toothpick.qualifier.InnerNavigationHolder
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

/**
 * Created on 13.12.18
 * @author YWeber
 * project BusinessCart */

class NavigationModule(router: Router) : Module() {
    init {
        val cicerone = Cicerone.create(FlowRouter(router))
        bind(FlowRouter::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).withName(InnerNavigationHolder::class.java).toInstance(cicerone.navigatorHolder)
    }

}