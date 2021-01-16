package com.amohnacs.squareemployeedirectory.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amohnacs.squareemployeedirectory.common.InjectionFragment
import com.amohnacs.squareemployeedirectory.common.ViewModelFactory
import com.amohnacs.squareemployeedirectory.databinding.MainFragmentBinding
import javax.inject.Inject

class MainFragment : InjectionFragment() {

    @Inject
    lateinit var factory: ViewModelFactory<MainViewModel>
    @Inject
    lateinit var adapter: EmployeeAdapter

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        mainDaggerComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater)
        binding.recyclerView.let {
            it.layoutManager = LinearLayoutManager(requireActivity())
            it.adapter = adapter
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        viewModel.getEmployees()
        viewModel.employees.observe(viewLifecycleOwner, Observer {
            binding.recyclerView.visibility = View.VISIBLE
            adapter.updateItems(it)
        })
        viewModel.errorLiveEvent.observe(viewLifecycleOwner, Observer {
            binding.errorText.visibility = View.VISIBLE
            binding.errorText.text = it
            binding.recyclerView.visibility = View.GONE
        })
        viewModel.loadingEvent.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                binding.loading.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
            } else {
                binding.loading.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
            }
        })
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}