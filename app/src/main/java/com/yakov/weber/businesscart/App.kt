package com.yakov.weber.businesscart

import android.app.Application
import com.yakov.weber.businesscart.toothpick.DI
import com.yakov.weber.businesscart.toothpick.module.AppModule
import timber.log.Timber
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
        initToothpick()
        initScope()
    }

    private fun initScope(){
        Toothpick.openScope(DI.AppScope).installModules(AppModule(this))
    }

    private fun initToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
            FactoryRegistryLocator.setRootRegistry(com.yakov.weber.businesscart.FactoryRegistry())
            MemberInjectorRegistryLocator.setRootRegistry(com.yakov.weber.businesscart.MemberInjectorRegistry())
        }
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }

}