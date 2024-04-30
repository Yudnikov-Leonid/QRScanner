package com.maxim.coremvvm.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.maxim.coremvvm.R
import com.maxim.coremvvm.core.sl.ProvideViewModel

class MainActivity : AppCompatActivity(), ProvideViewModel {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = viewModel(MainViewModel::class.java)

        viewModel.observe(this) {
            it.show(supportFragmentManager, R.id.container)
        }

        viewModel.init(savedInstanceState == null)
    }

    override fun <T : ViewModel> viewModel(clasz: Class<T>): T {
        return (application as ProvideViewModel).viewModel(clasz)
    }
}