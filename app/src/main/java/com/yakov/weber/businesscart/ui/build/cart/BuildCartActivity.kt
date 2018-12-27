package com.yakov.weber.businesscart.ui.build.cart

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.Toolbar
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.businesscart.R
import com.yakov.weber.businesscart.presenter.build.cart.BuildCartPresenter
import com.yakov.weber.businesscart.presenter.build.cart.BuildCartView
import com.yakov.weber.businesscart.toothpick.DI
import kotlinx.android.synthetic.main.toolbar.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import timber.log.Timber
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 27.12.18
 * @author YWeber
 * project BusinessCart */

class BuildCartActivity : MvpAppCompatActivity(),BuildCartView {

    @InjectPresenter
    lateinit var presenter: BuildCartPresenter

    @ProvidePresenter
    fun providerPresenter(): BuildCartPresenter = Toothpick
            .openScope(DI.APP_SCOPE)
            .getInstance(BuildCartPresenter::class.java)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = object : SupportAppNavigator(this, supportFragmentManager
            , R.id.build_container) {

        override fun setupFragmentTransaction(command: Command?,
                                              currentFragment: Fragment?,
                                              nextFragment: Fragment?,
                                              fragmentTransaction: FragmentTransaction?) {

            fragmentTransaction?.setReorderingAllowed(true)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(DI.APP_SCOPE))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_card)
        setToolbar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setToolbar(toolbar: Toolbar?) {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        } else {
            Timber.e("toolbar == null")
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }
    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()

    }
}