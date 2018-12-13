package com.yakov.weber.businesscart.toothpick.module

import com.yakov.weber.businesscart.system.FlowRouter
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module
import javax.inject.Qualifier

/**
 * Created on 13.12.18
 * @author YWeber
 * project BusinessCart */

class NavigationModule(router: Router) : Module() {
    init {
        val cicerone = Cicerone.create(FlowRouter())
        bind(FlowRouter::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)
    }

}