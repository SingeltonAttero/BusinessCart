package com.yakov.weber.businesscart

import android.support.v4.app.Fragment
import com.yakov.weber.businesscart.ui.draft.DraftFragment
import com.yakov.weber.businesscart.ui.navigation.NavigationFragment
import com.yakov.weber.businesscart.ui.ready.ReadyFragment
import com.yakov.weber.businesscart.ui.statistic.StatisticFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object NavigationMenuFlow: SupportAppScreen(){
        override fun getFragment(): Fragment {
            return NavigationFragment()
        }
    }

    object StatisticFlow : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return StatisticFragment()
        }
    }

    object DraftFlow : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return DraftFragment()
        }
    }

    object ReadyFlow : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return ReadyFragment()
        }
    }

}