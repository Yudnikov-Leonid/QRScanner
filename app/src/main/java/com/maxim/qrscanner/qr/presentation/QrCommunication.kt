package com.maxim.qrscanner.qr.presentation

import com.maxim.coremvvm.core.presentation.Communication

interface QrCommunication : Communication.Mutable<QrState> {
    class Base : QrCommunication, Communication.Regular<QrState>()
}