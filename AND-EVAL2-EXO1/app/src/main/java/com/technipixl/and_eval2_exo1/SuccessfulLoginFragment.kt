package com.technipixl.and_eval2_exo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.technipixl.and_eval2_exo1.databinding.FragmentSuccessfulLoginBinding

class SuccessfulLoginFragment : Fragment() {
    private lateinit var binding: FragmentSuccessfulLoginBinding

    private val args: SuccessfulLoginFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSuccessfulLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as AppCompatActivity

        val message = args.message
        val name = args.name

        if (message == "facebook") {
            binding.successfulLogo.setImageResource(R.drawable.facebook)
            activity.supportActionBar?.title = "FacebookConnected"
        } else if (message == "bloggies") {
            binding.welcomeText.text = "Bienvenue $name "
            activity.supportActionBar?.title = "BloggiesConnected"
        } else {
            binding.successfulLogo.setImageResource(R.drawable.twitter)
            activity.supportActionBar?.title = "TwitterConnected"
        }

    }
}