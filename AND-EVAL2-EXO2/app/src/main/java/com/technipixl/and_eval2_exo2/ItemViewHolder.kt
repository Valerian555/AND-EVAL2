package com.technipixl.and_eval2_exo2

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.technipixl.and_eval2_exo2.databinding.RowItemBinding

class ItemViewHolder(private var viewBinding: RowItemBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(item: Items) {
        viewBinding.itemName.text = item.name
        viewBinding.itemQuantity.text = item.quantity

        //Changement de l'image et de la couleur du texte en fonction de son type
        when (item.type) {
            Types.Maison -> {
                viewBinding.itemImage.setImageResource(R.drawable.home)
                viewBinding.itemName.setTextColor(viewBinding.root.context.getColor(R.color.pink))
            }

            Types.Boisson -> {
                viewBinding.itemImage.setImageResource(R.drawable.drink)
                viewBinding.itemName.setTextColor(viewBinding.root.context.getColor(R.color.purple))
            }

            Types.Nourriture -> {
                viewBinding.itemImage.setImageResource(R.drawable.food)
                viewBinding.itemName.setTextColor(viewBinding.root.context.getColor(R.color.blue))
            }

            else -> {
                viewBinding.itemImage.setImageResource(R.drawable.health)
                viewBinding.itemName.setTextColor(viewBinding.root.context.getColor(R.color.yellow))
            }
        }

        //afficher snackBAr lorsque je clique sur élément
        itemView.setOnClickListener {
            Snackbar.make(it.context, itemView, item.name, Snackbar.LENGTH_LONG).show()
        }
    }
}

