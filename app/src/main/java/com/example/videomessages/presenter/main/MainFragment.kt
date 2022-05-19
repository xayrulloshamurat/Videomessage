package com.example.videomessages.presenter.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.videomessages.R
import com.example.videomessages.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding
    private val adapterMain = MainAdapter()
    private val customerViewModel: CustomerViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        customerViewModel.customersFunc()
//        binding = FragmentMainBinding.bind(view)
//        binding.recyclerView.adapter = adapterMain
//        var spinner = binding.spinner
//        customerViewModel.customers.observe(viewLifecycleOwner) {
//
//        }
    }
}