package com.maxim.qrscanner.qr

import com.maxim.coremvvm.core.sl.Core
import com.maxim.coremvvm.core.sl.Module
import com.maxim.qrscanner.qr.presentation.QrCommunication
import com.maxim.qrscanner.qr.presentation.QrViewModel

class QrModule(private val core: Core) : Module<QrViewModel> {
    override fun viewModel() = QrViewModel(QrCommunication.Base(), core.navigation())
}