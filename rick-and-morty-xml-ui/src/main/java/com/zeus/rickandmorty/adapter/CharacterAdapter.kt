package com.zeus.rickandmorty.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.zeus.domain.models.Character
import com.zeus.rickandmorty.databinding.ItemCharacterBinding

class CharacterAdapter : ListAdapter<Character, CharacterAdapter.CharacterViewHolder>(CharacterDiffCallback()) {

    private var onCLickListener: (Character) -> Unit = {}

    fun setonClickListener(onCLickListener: (Character) -> Unit) {
        this.onCLickListener = onCLickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(getItem(position), onCLickListener)
    }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) : ViewHolder(binding.root) {
        fun onBind(character: Character, onCLickListener: (Character) -> Unit) {
            binding.root.setOnClickListener {
                onCLickListener.invoke(character)
            }
            binding.ivCharacter.load(character.image)
            binding.tvName.text = character.name
            binding.tvSpecies.text = character.species
        }
    }
}

class CharacterDiffCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }
}
