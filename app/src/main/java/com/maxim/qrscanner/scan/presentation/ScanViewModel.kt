package com.maxim.qrscanner.scan.presentation

import androidx.lifecycle.ViewModel
import com.maxim.coremvvm.core.presentation.Navigation
import com.maxim.coremvvm.core.presentation.Screen
import com.maxim.coremvvm.core.sl.ClearViewModel

class ScanViewModel(
    private val navigation: Navigation.Update,
    private val clearViewModel: ClearViewModel
): ViewModel() {

    fun decoded() {
        navigation.update(Screen.Pop)
        clearViewModel.clearViewModel(ScanViewModel::class.java)
    }
}