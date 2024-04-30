package com.maxim.qrscanner.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.maxim.coremvvm.core.presentation.Communication
import com.maxim.coremvvm.core.presentation.Init
import com.maxim.coremvvm.core.presentation.Navigation
import com.maxim.coremvvm.core.presentation.Screen
import com.maxim.qrscanner.qr.presentation.QrScreen

class MainViewModel(
    private val navigation: Navigation.Mutable
): ViewModel(), Init, Communication.Observe<Screen> {

    override fun init(isFirstRun: Boolean) {
        if (isFirstRun) {
            navigation.update(QrScreen)
        }
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<Screen>) {
        navigation.observe(owner, observer)
    }
}