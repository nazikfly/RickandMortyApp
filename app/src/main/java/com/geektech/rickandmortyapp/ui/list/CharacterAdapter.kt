package com.geektech.rickandmortyapp.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.geektech.rickandmortyapp.R
import com.geektech.rickandmortyapp.databinding.ItemListBinding

class CharacterAdapter:RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var listCharacter= emptyList<Character>()

    class CharacterViewHolder(private val binding: ItemListBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character){
            binding.tvId.text=character.id.toString
            binding.characterName.text=character.name
            binding.characterStatus.text=character.status

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding=ItemListBinding.inflate(layoutInflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(listCharacter[position])
        holder.itemView.setOnClickListener{ view->
            view.findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }
    }

    override fun getItemCount(): Int {
      return listCharacter.size
    }

    fun  setCharacters(characters:List<Character>){
        listCharacter=characters
        notifyDataSetChanged()
    }
}