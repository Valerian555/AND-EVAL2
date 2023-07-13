package com.technipixl.and_eval2_exo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.and_eval2_exo2.databinding.FragmentShoppingListBinding

class ShoppingListFragment : Fragment() {
    private lateinit var binding: FragmentShoppingListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        //visibilité texte "pas d'articles"
        if (itemList.isNotEmpty()) {
            binding.noItemsTitle.visibility = View.INVISIBLE
        }
    }


    private fun setupRecyclerView() {
        //récupération du composant RecyclerView
        val recyclerView = binding?.itemRecyclerView

        //defintion de son layout
        recyclerView?.layoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false
        )

        recyclerView?.adapter = ItemAdapter(itemList)
    }
}