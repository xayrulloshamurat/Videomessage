package com.example.videomessages.presenter.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.videomessages.R
import com.example.videomessages.data.model.Customer
import com.example.videomessages.databinding.CustomerItemBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var models: List<Customer> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(var binding: CustomerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun populateModel(customer: Customer) {
            binding.firstName.text = customer.username
            binding.lastName.text = customer.lastName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_main, parent, false)
        val binding = CustomerItemBinding.bind(view)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}