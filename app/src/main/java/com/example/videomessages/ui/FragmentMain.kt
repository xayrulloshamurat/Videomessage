package com.example.videomessages.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.videomessages.CustomerViewModel
import com.example.videomessages.MainAdapter
import com.example.videomessages.R
import com.example.videomessages.data.ResourceState
import com.example.videomessages.databinding.CustomerItemBinding
import com.example.videomessages.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class FragmentMain : Fragment(R.layout.fragment_main), AdapterView.OnItemClickListener {
    private lateinit var binding: FragmentMainBinding
    private val adapterMain = MainAdapter()
    private val customerViewModel: CustomerViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        customerViewModel.customersFunc()
        binding.recyclerView.adapter = adapterMain
        var spinner = binding.spinner



        customerViewModel.customers.observe(viewLifecycleOwner) {
            when (it.status) {
                ResourceState.LOADING -> {

                }
                ResourceState.SUCCESS -> {
                    if (spinner != null) {
                        val adapter = ArrayAdapter(
                            requireContext(),
                            android.R.layout.simple_spinner_item,
                            it.
                        )

                        spinner.adapter = adapter

                        spinner.onItemSelectedListener = object :
                            AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>,
                                view: View, position: Int, id: Long
                            ) {
                                Toast.makeText(
                                    requireContext(),
                                    getString(R.string.selected_item) + " " +
                                            "" +  it.data!![position], Toast.LENGTH_SHORT
                                ).show()
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                                TODO("Not yet implemented")
                            }

                        }

                    }
                }
                ResourceState.ERROR -> {

                }
            }
        }
    }


    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }
}