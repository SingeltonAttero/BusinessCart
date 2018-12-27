package com.yakov.weber.businesscart.presenter.build.cart

import com.arellomobile.mvp.InjectViewState
import com.yakov.weber.businesscart.Screens
import com.yakov.weber.businesscart.presenter.global.BasePresenter
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import javax.inject.Inject

/**
 * Created on 27.12.18
 * @author YWeber
 * project BusinessCart */
@InjectViewState
class BuildCartPresenter @Inject constructor(private val router: Router) : BasePresenter<BuildCartView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.BuildCartFlow)
    }

}