package com.maxim.qrscanner.qr.data

import com.maxim.coremvvm.core.presentation.Reload

interface ShareQrResult {
    interface Update {
        fun save(text: String)
    }
    interface Read {
        fun read(): String
        fun setReload(reload: Reload)
    }
    interface Mutable: Update, Read

    class Base: Mutable {
        private var cachedText = ""
        private var callback: Reload? = null

        override fun save(text: String) {
            cachedText = text
            callback?.reload()
        }

        override fun read() = cachedText
        override fun setReload(reload: Reload) {
            callback = reload
        }
    }
}