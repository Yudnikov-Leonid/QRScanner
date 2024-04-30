package com.maxim.coremvvm.core

import android.app.Application
import androidx.lifecycle.ViewModel
import com.maxim.coremvvm.core.sl.ClearViewModel
import com.maxim.coremvvm.core.sl.Core
import com.maxim.coremvvm.core.sl.DependencyContainer
import com.maxim.coremvvm.core.sl.ProvideViewModel
import com.maxim.coremvvm.core.sl.ViewModelFactory

class App: Application(), ProvideViewModel {
    private lateinit var factory: ViewModelFactory

    override fun onCreate() {
        super.onCreate()
        val core = Core.Base(this)
        val dependencyContainer = DependencyContainer.Base(core, object : ClearViewModel {
            override fun clearViewModel(clasz: Class<out ViewModel>) {
                factory.clearViewModel(clasz)
            }
        })
        factory = ViewModelFactory.Base(ProvideViewModel.Base(dependencyContainer))
    }

    override fun <T : ViewModel> viewModel(clasz: Class<T>): T {
        return factory.viewModel(clasz)
    }
}