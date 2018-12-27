package com.yakov.weber.businesscart.ui.global

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.yakov.weber.businesscart.system.disposable.ComponentDisposableBind
import com.yakov.weber.businesscart.system.disposable.ComponentDisposableBindImpl
import com.yakov.weber.businesscart.ui.MainActivity
import com.yakov.weber.businesscart.ui.ProgressDialogFragment

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */

abstract class BaseFragment : MvpAppCompatFragment(),ComponentDisposableBind by ComponentDisposableBindImpl(){

    companion object {
        const val DIALOG_TAG = "dialog fragment"
    }

    abstract val layoutRes: Int @LayoutRes get

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes,container,false)
    }

    fun setToolbar(toolbar:Toolbar,title:String = ""){
        val mainActivity = activity as MainActivity
        toolbar.title = title
        mainActivity.setToolbar(toolbar)
    }


    fun showDialog(progress:Boolean){
        val fragment = childFragmentManager.findFragmentByTag(DIALOG_TAG)
        if (fragment != null && !progress){
            (fragment as ProgressDialogFragment).dismissAllowingStateLoss()
            childFragmentManager.executePendingTransactions()
        }else if (fragment == null && progress){
            val progressDialogFragment = ProgressDialogFragment()
            progressDialogFragment.show(childFragmentManager, DIALOG_TAG)
            childFragmentManager.executePendingTransactions()
        }
    }

    override fun onDestroy() {
        clear()
        super.onDestroy()
    }
}