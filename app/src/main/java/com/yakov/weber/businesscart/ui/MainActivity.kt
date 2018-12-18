package com.yakov.weber.businesscart.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.Toolbar
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.businesscart.R
import com.yakov.weber.businesscart.presenter.MainPresenter
import com.yakov.weber.businesscart.presenter.MainView
import com.yakov.weber.businesscart.system.message.SystemMessageNotifier
import com.yakov.weber.businesscart.system.message.SystemMessageType
import com.yakov.weber.businesscart.toothpick.DI
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.toast
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import timber.log.Timber
import toothpick.Toothpick
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providerPresenter(): MainPresenter = Toothpick
        .openScope(DI.APP_SCOPE)
        .getInstance(MainPresenter::class.java)

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    @Inject
    lateinit var systemMessageNotifier: SystemMessageNotifier

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(DI.APP_SCOPE))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private val navigator :Navigator  by lazy {  object : SupportAppNavigator(this, supportFragmentManager, R.id.app_container) {
        override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction?
        ) {
            fragmentTransaction?.setReorderingAllowed(true)
        }

        override fun activityBack() {
            finish()
        }
    } }

    fun setToolbar(toolbar: Toolbar?) {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        } else {
            Timber.e("toolbar == null")
        }
    }

    override fun onResume() {
        super.onResume()
        navigationHolder.setNavigator(navigator)
        systemMessage()
    }
    override fun onPause() {
        navigationHolder.removeNavigator()
        disposable?.dispose()
        super.onPause()

    }

    private fun systemMessage() {
        disposable = systemMessageNotifier.notifier()
            .subscribe {
                when (it.type) {
                    SystemMessageType.TOAST -> toast(it.message)
                    SystemMessageType.ALERT -> {
                    }
                }
            }
    }

}
