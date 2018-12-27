package com.yakov.weber.businesscart.ui
import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatDialogFragment
import com.yakov.weber.businesscart.R

/**
 * Created on 26.12.18
 * @author YWeber
 * project BusinessCart */

class ProgressDialogFragment : MvpAppCompatDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setStyle(STYLE_NO_FRAME, R.style.ProgressDialogTheme)
        isCancelable = false
        return inflater.inflate(R.layout.progress_dialog,container,false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(requireContext(),R.style.ProgressDialogTheme)
            .setView(R.layout.progress_dialog)
            .create()
        return dialog
    }
}