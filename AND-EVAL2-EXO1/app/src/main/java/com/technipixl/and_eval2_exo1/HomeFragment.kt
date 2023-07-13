package com.technipixl.and_eval2_exo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.technipixl.and_eval2_exo1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.facebookConnectionButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment("facebook"))
        }

        binding.twitterConnectionButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment("twitter"))
        }

        binding.createAccountButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSignUpFragment())
        }

        // change le titre de l'action bar
        val activity = requireActivity() as AppCompatActivity   //require donne l'activité parente
        activity.supportActionBar?.title = "Bloggies"
    }

}