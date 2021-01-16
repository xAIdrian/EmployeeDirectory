package com.amohnacs.squareemployeedirectory.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.amohnacs.squareemployeedirectory.databinding.FragmentMainItemBinding
import com.amohnacs.squareemployeedirectory.model.Employee
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import javax.inject.Inject

class EmployeeAdapter @Inject constructor() : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {

    private var values: List<Employee> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                FragmentMainItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = values.size

    // these two override meethods ensure we have set stable IDs for our row items
    // this eliminates random swapping
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(view: ViewBinding) : RecyclerView.ViewHolder(view.root) {
        private val binding = view as FragmentMainItemBinding
        fun bind(employee: Employee) {
            Glide.with(binding.root.context)
                    .load(employee.photoUrlSmall)
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.image)
            binding.name.text = employee.fullName
            binding.email.text = employee.emailAddress
            binding.number.text = employee.phoneNumber
            binding.employeeType.text = employee.employeeType?.value
            binding.biography.text = employee.biography
        }
    }

    fun updateItems(employees: List<Employee>) {
        values = employees
        notifyDataSetChanged()
    }
}