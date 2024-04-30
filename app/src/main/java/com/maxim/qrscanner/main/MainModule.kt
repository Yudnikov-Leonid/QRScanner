package com.maxim.coremvvm.main

import com.maxim.coremvvm.core.sl.Core
import com.maxim.coremvvm.core.sl.Module

class MainModule(private val core: Core): Module<MainViewModel> {
    override fun viewModel() = MainViewModel(core.navigation())
}