package com.yakov.weber.businesscart

import android.support.v4.app.Fragment
import com.yakov.weber.businesscart.ui.navigation.NavigationFragment
import com.yakov.weber.businesscart.ui.ready.ReadyFrament
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object NavigationMenuFlow: SupportAppScreen(){
        override fun getFragment(): Fragment {
            return NavigationFragment()
        }
    }

    object ReadyFlow : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return ReadyFrament()
        }
    }

}