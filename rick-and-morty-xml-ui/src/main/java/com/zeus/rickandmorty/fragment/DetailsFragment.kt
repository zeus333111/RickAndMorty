package com.zeus.rickandmorty.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.zeus.domain.models.Character
import com.zeus.presentation.viewmodel.DetailsViewModel
import com.zeus.rickandmorty.databinding.FragmentDetailsBinding
import com.zeus.rickandmorty.utils.dateFormatter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: DetailsViewModel by viewModels()
    private var characterId: String? = null
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        characterId = args.characterId
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViews()
        setupObservers()
        characterId?.let {
            viewModel.getCharacter(it)
        }
    }

    private fun setupViews() = with(binding) {
        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun setupObservers() {
        viewModel.state.observe(viewLifecycleOwner) {
            if (it.isLoading) {
                binding.progressBarView.root.visibility = View.VISIBLE
            } else {
                binding.progressBarView.root.visibility = View.GONE
            }

            it.character?.let { character ->
                setCharacterData(character)
            }
        }
    }

    private fun setCharacterData(character: Character) = with(binding) {
        ivCharacter.load(character.image)
        tvCreationDate.text = dateFormatter(character.created)
        tvStatus.text = character.status
        tvSpecies.text = character.species
        tvType.text = character.type.ifEmpty { "N/A" }
        tvGender.text = character.gender
        tvOrigin.text = character.origin.name
        tvLastLocation.text = character.location.name
    }
}
