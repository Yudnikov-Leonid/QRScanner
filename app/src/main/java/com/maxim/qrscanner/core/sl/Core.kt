package com.maxim.coremvvm.core.sl

import android.content.Context
import com.maxim.coremvvm.core.data.ManageResource
import com.maxim.coremvvm.core.data.SimpleStorage
import com.maxim.coremvvm.core.presentation.Navigation

interface Core : ProvideManageResource, ProvideNavigation, ProvideSimpleStorage {

    class Base(private val context: Context) : Core {

        private val manageResource by lazy { ManageResource.Base(context) }
        private val navigation = Navigation.Base()

        override fun manageResource() = manageResource

        override fun navigation(): Navigation.Mutable = navigation
        private val simpleStorage =
            SimpleStorage.Base(context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE))

        override fun simpleStorage() = simpleStorage

        companion object {
            private const val STORAGE_NAME = "STORAGE"
        }
    }
}

interface ProvideManageResource {
    fun manageResource(): ManageResource
}

interface ProvideNavigation {
    fun navigation(): Navigation.Mutable
}

interface ProvideSimpleStorage {
    fun simpleStorage(): SimpleStorage
}