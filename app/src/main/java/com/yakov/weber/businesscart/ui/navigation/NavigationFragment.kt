package com.yakov.weber.businesscart.ui.navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding2.support.design.widget.RxBottomNavigationView
import com.yakov.weber.businesscart.R
import com.yakov.weber.businesscart.presenter.navigation.NavigationPresenter
import com.yakov.weber.businesscart.presenter.navigation.NavigationView
import com.yakov.weber.businesscart.toothpick.DI
import com.yakov.weber.businesscart.toothpick.module.NavigationModule
import com.yakov.weber.businesscart.toothpick.qualifier.InnerNavigationHolder
import com.yakov.weber.businesscart.ui.global.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_navigation.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.support.v4.toast
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import toothpick.Toothpick
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created on 11.12.18
 * @author YWeber
 * project BusinessCart */

class NavigationFragment : BaseFragment() , NavigationView {
    @InjectPresenter
    lateinit var presenter:NavigationPresenter
    @ProvidePresenter
    fun providerPresenter(): NavigationPresenter = Toothpick.openScopes(DI.APP_SCOPE, DI.NAVIGATION_SCOPE)
        .getInstance(NavigationPresenter::class.java)

    @Inject
    @InnerNavigationHolder
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator by lazy {
        object : SupportAppNavigator(activity, fragmentManager, R.id.fragment_container) {
            override fun setupFragmentTransaction(command: Command?, currentFragment: Fragment?,
                                                  nextFragment: Fragment?, fragmentTransaction: FragmentTransaction?) {
                fragmentTransaction?.setReorderingAllowed(true)
            }
        }
    }

    override val layoutRes: Int
        get() = R.layout.fragment_navigation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar(toolbar,getString(R.string.app_name))
        rxInitView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val openScopes = Toothpick.openScopes(DI.APP_SCOPE, DI.NAVIGATION_SCOPE)
        openScopes.installModules(NavigationModule(openScopes.getInstance(Router::class.java)))
        Toothpick.inject(this, openScopes)
        super.onCreate(savedInstanceState)
    }
    private fun rxInitView(){
        RxBottomNavigationView.itemSelections(main_button_navigation)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                when(it.itemId){
                    R.id.ready_menu -> {
                        presenter.openReadyFlow()
                    }
                    R.id.draft_menu -> {
                        presenter.goToDraftFlow()
                    }
                    R.id.statistic_menu -> {
                        presenter.goToStatisticFlow()
                    }
                }
            }
            .bind()
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