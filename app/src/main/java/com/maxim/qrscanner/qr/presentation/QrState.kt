package com.maxim.qrscanner.qr.presentation

import android.widget.TextView

interface QrState {
    fun show(resultTextView: TextView)

    class Base(private val text: String): QrState {
        override fun show(resultTextView: TextView) {
            resultTextView.text = text
        }
    }
}