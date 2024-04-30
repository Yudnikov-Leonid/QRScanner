package com.maxim.qrscanner.qr.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.maxim.coremvvm.core.presentation.Communication
import com.maxim.coremvvm.core.presentation.Init
import com.maxim.coremvvm.core.presentation.Navigation
import com.maxim.coremvvm.core.presentation.Reload
import com.maxim.qrscanner.qr.data.ShareQrResult
import com.maxim.qrscanner.scan.presentation.ScanScreen

class QrViewModel(
    private val shareQrResult: ShareQrResult.Read,
    private val communication: QrCommunication,
    private val navigation: Navigation.Update
): ViewModel(), Communication.Observe<QrState>, Init, Reload {

    override fun init(isFirstRun: Boolean) {
        shareQrResult.setReload(this)
    }

    override fun reload() {
        communication.update(QrState.Base(shareQrResult.read()))
    }

    fun scan() {
        navigation.update(ScanScreen)
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<QrState>) {
        communication.observe(owner, observer)
    }
}