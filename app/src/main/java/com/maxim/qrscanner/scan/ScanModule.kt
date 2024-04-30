package com.maxim.qrscanner.scan

import com.maxim.coremvvm.core.sl.ClearViewModel
import com.maxim.qrscanner.core.sl.Core
import com.maxim.coremvvm.core.sl.Module
import com.maxim.qrscanner.scan.presentation.ScanViewModel

class ScanModule(private val core: Core, private val clearViewModel: ClearViewModel): Module<ScanViewModel> {
    override fun viewModel() = ScanViewModel(core.shareQrResult(), core.navigation(), clearViewModel)
}