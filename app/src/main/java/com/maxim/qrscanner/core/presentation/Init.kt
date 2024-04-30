package com.maxim.coremvvm.core.presentation

interface Init {
    fun init(isFirstRun: Boolean)
}

interface SimpleInit {
    fun init()
}