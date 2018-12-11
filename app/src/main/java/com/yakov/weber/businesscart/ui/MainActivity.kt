package com.yakov.weber.businesscart.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakov.weber.businesscart.R
import com.yakov.weber.businesscart.presenter.MainPresenter
import com.yakov.weber.businesscart.presenter.MainView
import com.yakov.weber.businesscart.system.message.SystemMessageNotifier
import com.yakov.weber.businesscart.system.message.SystemMessageType
import com.yakov.weber.businesscart.toothpick.DI
import com.yakov.weber.businesscart.ui.navigation.NavigationFragment
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import toothpick.Toothpick
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity() , MainView {

    @InjectPresenter
    lateinit var presenter:MainPresenter

    @ProvidePresenter
    fun providerPresenter(): MainPresenter = Toothpick
        .openScope(DI.AppScope)
        .getInstance(MainPresenter::class.java)

    @Inject
    lateinit var systemMessageNotifier:SystemMessageNotifier

    private var disposable:Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this,Toothpick.openScope(DI.AppScope))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.app_container,NavigationFragment())
            .commit()
    }

    override fun onStart() {
        super.onStart()
        systemMessage()
    }

    override fun onStop() {
        disposable?.dispose()
        super.onStop()
    }

    private fun systemMessage() {
        disposable = systemMessageNotifier.notifier()
            .subscribe {
                when(it.type){
                    SystemMessageType.TOAST -> toast(it.message)
                    SystemMessageType.ALERT -> {}
                }
            }
    }

}
