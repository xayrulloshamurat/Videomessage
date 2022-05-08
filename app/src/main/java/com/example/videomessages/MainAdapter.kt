package com.example.videomessages

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.videomessages.data.models.Customer
import com.example.videomessages.databinding.CustomerItemBinding
import com.example.videomessages.databinding.FragmentMainBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    var models: List<Customer> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class ViewHolder(var binding: CustomerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun populateModel(customer: Customer) {
            binding.tvTitle.text = customer.name
            binding.tvPrice.text = customer.lastName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_main, parent, false)
        var binding = CustomerItemBinding.bind(view)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}