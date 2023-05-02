package com.example.fitnesstestapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstestapp.databinding.FragmentTrainingListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class TrainingListFragment : Fragment() {

    private val viewModel: TrainingListViewModel by viewModel()
    private lateinit var adapter: DateListAdapter
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentTrainingListBinding? = null
    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.getListOfDay()
        _binding = FragmentTrainingListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.rvListOfDate
        viewModel.listOfDay.observe(viewLifecycleOwner) {

            adapter = DateListAdapter(it)
            recyclerView.adapter = adapter
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}