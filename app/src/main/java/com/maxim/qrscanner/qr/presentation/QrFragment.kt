package com.maxim.qrscanner.qr.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maxim.coremvvm.core.presentation.BaseFragment
import com.maxim.qrscanner.databinding.FragmentQrBinding

class QrFragment: BaseFragment<FragmentQrBinding, QrViewModel>() {
    override val viewModelClass = QrViewModel::class.java
    override fun bind(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentQrBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.observe(this) {

        }

        viewModel.init(savedInstanceState == null)
    }
}