package com.yakov.weber.businesscart.ui.navigation

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding2.support.design.widget.RxBottomNavigationView
import com.yakov.weber.businesscart.R
import com.yakov.weber.businesscart.Screens
import com.yakov.weber.businesscart.presenter.navigation.NavigationPresenter
import com.yakov.weber.businesscart.presenter.navigation.NavigationView
import com.yakov.weber.businesscart.toothpick.DI
import com.yakov.weber.businesscart.ui.global.BaseFragment
import kotlinx.android.synthetic.main.fragment_navigation.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.support.v4.toast
import toothpick.Toothpick

/**
 * Created on 11.12.18
 * @author YWeber
 * project BusinessCart */

class NavigationFragment : BaseFragment() , NavigationView {
    @InjectPresenter
    lateinit var presenter:NavigationPresenter
    @ProvidePresenter
    fun providerPresenter(): NavigationPresenter = Toothpick.openScope(DI.AppScope)
        .getInstance(NavigationPresenter::class.java)

    override val layoutRes: Int
        get() = R.layout.fragment_navigation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar(toolbar,getString(R.string.app_name))
        rxInitView()
    }
    private fun rxInitView(){
        RxBottomNavigationView.itemSelections(main_button_navigation)
            .subscribe {
                when(it.itemId){
                    R.id.ready_menu -> {
                       /* fragmentManager
                            ?.beginTransaction()
                            ?.replace(R.id.fragment_container,NavigationFragment())
                            ?.commit()*/
                    }
                    R.id.draft_menu -> {}
                    R.id.statistic_menu -> {}
                }
            }
            .bind()
    }
}