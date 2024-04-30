package com.maxim.coremvvm.core.presentation

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

interface Screen {
    fun show(fragmentManager: FragmentManager, containerId: Int)
    abstract class Replace(private val fragmentClass: Class<out Fragment>) : Screen {
        override fun show(fragmentManager: FragmentManager, containerId: Int) {
            for(i in 0..<fragmentManager.backStackEntryCount) {
                fragmentManager.popBackStack()
            }
            fragmentManager.beginTransaction()
                .replace(containerId, fragmentClass.getDeclaredConstructor().newInstance()).commit()
        }
    }

    abstract class AddWithAnimation(private val fragmentClass: Class<out Fragment>) : Screen {
        override fun show(fragmentManager: FragmentManager, containerId: Int) {
            fragmentManager.beginTransaction()
                .setCustomAnimations(
                    com.google.android.material.R.anim.m3_side_sheet_enter_from_right,
                    com.google.android.material.R.anim.m3_side_sheet_exit_to_right,
                    com.google.android.material.R.anim.m3_side_sheet_enter_from_right,
                    com.google.android.material.R.anim.m3_side_sheet_exit_to_right
                )
                .add(containerId, fragmentClass.getDeclaredConstructor().newInstance())
                .addToBackStack("")
                .commit()
        }
    }

    abstract class Dialog(private val fragmentClass: Class<out DialogFragment>) : Screen {
        override fun show(fragmentManager: FragmentManager, containerId: Int) {
            fragmentClass.getDeclaredConstructor().newInstance().show(fragmentManager, "")
        }
    }

    abstract class BottomSheetFragment(private val fragmentClass: Class<out BottomSheetDialogFragment>) :
        Screen {
        override fun show(fragmentManager: FragmentManager, containerId: Int) {
            fragmentClass.getDeclaredConstructor().newInstance().show(fragmentManager, "")
        }
    }

    object Pop : Screen {
        override fun show(fragmentManager: FragmentManager, containerId: Int) {
            fragmentManager.popBackStack()
        }
    }
}