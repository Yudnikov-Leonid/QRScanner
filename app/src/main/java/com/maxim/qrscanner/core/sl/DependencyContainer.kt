package com.maxim.coremvvm.core.sl

import androidx.lifecycle.ViewModel
import com.maxim.coremvvm.main.MainModule
import com.maxim.coremvvm.main.MainViewModel

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
            else -> dependencyContainer.module(clasz)
        } as Module<T>
    }
}