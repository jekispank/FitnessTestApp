package com.example.fitnesstestapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.fitnesstestapp.R
import com.example.fitnesstestapp.databinding.FragmentRootBinding

class RootFragment : Fragment() {

    private var _binding: FragmentRootBinding? = null
    private val binding get() = _binding!!
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRootBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.root_container) as NavHostFragment

        navController = navHostFragment.navController

        binding.bottomBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bt_lessons -> {
                    navigateTo(TrainingListFragment())
                }

                R.id.bt_request
                -> {
                    Toast.makeText(requireContext(), "Хоба!", Toast.LENGTH_SHORT).show()
                }

                R.id.bt_add
                -> {
                    Toast.makeText(requireContext(), "Хоба!", Toast.LENGTH_SHORT).show()
                }

                R.id.bt_chat
                -> {
                    Toast.makeText(requireContext(), "Хоба!", Toast.LENGTH_SHORT).show()
                }

                R.id.bt_more
                -> {
                    Toast.makeText(requireContext(), "Хоба!", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    private fun navigateTo(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.root_container, fragment)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}