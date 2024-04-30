package com.maxim.qrscanner.scan.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ScanMode
import com.maxim.coremvvm.core.presentation.BaseFragment
import com.maxim.qrscanner.databinding.FragmentScanBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ScanFragment: BaseFragment<FragmentScanBinding, ScanViewModel>() {
    override val viewModelClass =ScanViewModel::class.java
    override fun bind(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentScanBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scanner = CodeScanner(requireContext(), binding.scannerView).apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS
            autoFocusMode = AutoFocusMode.SAFE
            scanMode =  ScanMode.SINGLE
            isAutoFocusEnabled = true
            isFlashEnabled = false
        }

        scanner.decodeCallback = DecodeCallback {
            GlobalScope.launch(Dispatchers.Main) {
                Toast.makeText(requireContext(), "text: ${it.text}", Toast.LENGTH_LONG).show()
                viewModel.decoded()
            }
        }
        scanner.startPreview()
    }
}