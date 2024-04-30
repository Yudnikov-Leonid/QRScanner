package com.maxim.qrscanner.qr.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.maxim.coremvvm.core.presentation.Communication
import com.maxim.coremvvm.core.presentation.Init
import com.maxim.coremvvm.core.presentation.Navigation

class QrViewModel(
    private val communication: QrCommunication,
    private val navigation: Navigation.Update
): ViewModel(), Communication.Observe<QrState>, Init {

    override fun init(isFirstRun: Boolean) {
        TODO("Not yet implemented")
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<QrState>) {
        communication.observe(owner, observer)
    }
}