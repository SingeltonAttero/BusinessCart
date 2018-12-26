package com.yakov.weber.businesscart.model.data

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import org.jetbrains.anko.toast

/**
 * Created on 24.12.18
 * @author YWeber
 * project BusinessCart */

class ServerLifecycle(private val context: Context) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun anyLifecycle(owner: LifecycleOwner, lifeEvent: Lifecycle.Event) {
        when (lifeEvent) {
            Lifecycle.Event.ON_START -> {
                toast("Lifecycle.Event.ON_START")
            }
            Lifecycle.Event.ON_STOP -> {
                toast("Lifecycle.Event.ON_STOP")
            }
            Lifecycle.Event.ON_CREATE -> {
                toast("Lifecycle.Event.ON_CREATE")
            }
            Lifecycle.Event.ON_PAUSE -> {
                toast("Lifecycle.Event.ON_PAUSE")
            }
            Lifecycle.Event.ON_DESTROY -> {
                toast("Lifecycle.Event.ON_DESTROY")
            }
            Lifecycle.Event.ON_RESUME -> {
                toast(" Lifecycle.Event.ON_RESUME")
            }
            Lifecycle.Event.ON_ANY -> {
                toast("Lifecycle.Event.ON_ANY")
            }
        }
    }

    fun toast(message: String) {
        context.toast(message)
    }


}