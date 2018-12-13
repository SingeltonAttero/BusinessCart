package com.yakov.weber.businesscart.system

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen

/**
 * Created on 13.12.18
 * @author YWeber
 * project BusinessCart */
 
class FlowRouter() : Router(){
    fun startFlow(screen:Screen){
        navigateTo(screen)
    }

    fun newRootFlow(screen:Screen){
        newRootScreen(screen)
    }

    fun toExit(){
        exit()
    }
}