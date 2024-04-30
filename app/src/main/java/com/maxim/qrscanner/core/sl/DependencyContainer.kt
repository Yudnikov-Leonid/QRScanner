package com.maxim.qrscanner.core.sl

import androidx.lifecycle.ViewModel
import com.maxim.coremvvm.core.sl.ClearViewModel
import com.maxim.coremvvm.core.sl.Module
import com.maxim.coremvvm.main.MainModule
import com.maxim.qrscanner.main.MainViewModel
import com.maxim.qrscanner.qr.QrModule
import com.maxim.qrscanner.qr.presentation.QrViewModel
import com.maxim.qrscanner.scan.ScanModule
import com.maxim.qrscanner.scan.presentation.ScanViewModel

interface DependencyContainer {
    fun <T : ViewModel> module(clasz: Class<T>): Module<T>

    class Error : DependencyContainer {
        override fun <T : ViewModel> module(clasz: Class<T>) =
            throw IllegalStateException("unknown viewModel $clasz")
    }

    class Base(
        private val core: Core,
        private val clear: ClearViewModel,
        private val dependencyContainer: DependencyContainer = Error()
    ) : DependencyContainer {
        override fun <T : ViewModel> module(clasz: Class<T>) = when (clasz) {
            MainViewModel::class.java -> MainModule(core)
            QrViewModel::class.java -> QrModule(core)
            ScanViewModel::class.java -> ScanModule(core, clear)
            else -> dependencyContainer.module(clasz)
        } as Module<T>
    }
}