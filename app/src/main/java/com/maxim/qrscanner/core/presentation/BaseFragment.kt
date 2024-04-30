package com.maxim.coremvvm.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.maxim.coremvvm.core.sl.ProvideViewModel

abstract class BaseFragment<B : ViewBinding, V : ViewModel> : Fragment() {
    private var _binding: B? = null
    protected val binding get() = _binding!!
    protected var onBackPressedCallback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }

    protected abstract fun bind(inflater: LayoutInflater, container: ViewGroup?): B
    protected lateinit var viewModel: V
    protected abstract val viewModelClass: Class<out V>
    protected open var setOnBackPressedCallback = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (setOnBackPressedCallback)
            requireActivity().onBackPressedDispatcher.addCallback(onBackPressedCallback)
        viewModel = (activity as ProvideViewModel).viewModel(viewModelClass)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bind(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onBackPressedCallback.remove()
        _binding = null
    }
}