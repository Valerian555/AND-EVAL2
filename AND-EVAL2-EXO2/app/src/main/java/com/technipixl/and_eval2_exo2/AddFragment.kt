package com.technipixl.and_eval2_exo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.technipixl.and_eval2_exo2.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.saveButton.setOnClickListener {
            val name = binding.itemNameEditText.text.toString()
            val quantity = binding.itemquantityEditText.text.toString()

            val type: Types
            when {
                binding.radioFood.isChecked -> type = Types.Nourriture
                binding.radioDrink.isChecked -> type = Types.Boisson
                binding.radioHouse.isChecked -> type = Types.Maison
                else -> type = Types.Hygiène
            }

            itemList.add(Items(name, quantity, type))
            findNavController().navigateUp()
        }
    }
}