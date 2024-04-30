package com.maxim.qrscanner.scan.presentation

import androidx.lifecycle.ViewModel
import com.maxim.coremvvm.core.presentation.Navigation
import com.maxim.coremvvm.core.presentation.Screen
import com.maxim.coremvvm.core.sl.ClearViewModel
import com.maxim.qrscanner.qr.data.ShareQrResult

class ScanViewModel(
    private val shareQrResult: ShareQrResult.Update,
    private val navigation: Navigation.Update,
    private val clearViewModel: ClearViewModel
): ViewModel() {

    fun decoded(text: String) {
        shareQrResult.save(text)
        navigation.update(Screen.Pop)
        clearViewModel.clearViewModel(ScanViewModel::class.java)
    }
}