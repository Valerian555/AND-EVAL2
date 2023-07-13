package com.technipixl.and_eval2_exo2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.and_eval2_exo2.databinding.RowItemBinding

//En charge de gérer l'ensemble des cellules
class ItemAdapter(private var items: MutableList<Items>)
    : RecyclerView.Adapter<ItemViewHolder>() {
    private lateinit var binding: RowItemBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        //charge le layout de la cellule
        binding = RowItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return items.size
    }
}