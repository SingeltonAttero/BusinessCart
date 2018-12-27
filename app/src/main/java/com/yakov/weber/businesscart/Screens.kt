package com.yakov.weber.businesscart

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.yakov.weber.businesscart.ui.build.cart.BuildCardFragment
import com.yakov.weber.businesscart.ui.build.cart.BuildCartActivity
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

    object BuildCartScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context, BuildCartActivity::class.java)
        }
    }

    object BuildCartFlow : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return BuildCardFragment()
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