package com.zeus.rickandmorty.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.zeus.presentation.viewmodel.HomeViewModel
import com.zeus.rickandmorty.adapter.CharacterAdapter
import com.zeus.rickandmorty.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val adapter by lazy {
        CharacterAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupView()
        setupObservers()
        viewModel.getCharacters(false)
    }

    private fun setupView() {
        adapter.setonClickListener {
            // todo navigate to details
        }
        binding.rvCharacters.adapter = adapter
        binding.btnPreviousPage.setOnClickListener {
            viewModel.getCharacters(false)
        }
        binding.btnNextPage.setOnClickListener {
            viewModel.getCharacters(true)
        }
    }

    private fun setupObservers() {
        viewModel.state.observe(viewLifecycleOwner) {
            if (it.isLoading) {
                binding.progressBarView.root.visibility = View.VISIBLE
            } else {
                binding.progressBarView.root.visibility = View.GONE
            }

            if (it.showError) {
                // todo error view
            }

            binding.btnNextPage.isEnabled = it.showNext

            binding.btnPreviousPage.isEnabled = it.showPrevious

            if (it.characters.isNotEmpty()) {
                adapter.submitList(it.characters)
            }
        }
    }
}
