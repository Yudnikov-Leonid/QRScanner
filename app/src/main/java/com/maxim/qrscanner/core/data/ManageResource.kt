package com.maxim.coremvvm.core.data

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

interface ManageResource {

    fun drawable(@DrawableRes id: Int): Drawable
    fun raw(id: Int): String
    fun string(id: Int): String

    class Base(private val context: Context): ManageResource {
        override fun drawable(id: Int): Drawable = ContextCompat.getDrawable(context, id)!!
        override fun raw(id: Int) = context.resources.openRawResource(id).bufferedReader().readText()
        override fun string(id: Int) = context.resources.getString(id)
    }
}