package com.yakov.weber.businesscart.toothpick.module

import android.content.Context
import com.yakov.weber.businesscart.system.ResourceManager
import com.yakov.weber.businesscart.system.message.SystemMessage
import com.yakov.weber.businesscart.system.message.SystemMessageNotifier
import com.yakov.weber.businesscart.system.shceduler.AppScheduler
import com.yakov.weber.businesscart.system.shceduler.SchedulersProvider
import timber.log.Timber
import toothpick.config.Module

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */

class AppModule(context: Context) : Module() {
    init {
        Timber.d("init app module")
        bind(Context::class.java).toInstance(context)
        bind(ResourceManager::class.java).toInstance(ResourceManager(context))
        bind(SystemMessageNotifier::class.java).toInstance(SystemMessageNotifier())
        bind(SchedulersProvider::class.java).toInstance(AppScheduler())
    }
}