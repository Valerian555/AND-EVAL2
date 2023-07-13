package com.technipixl.and_eval2_exo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.technipixl.and_eval2_exo1.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val args: LoginFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //titre de l'action bar
        val activity = requireActivity() as AppCompatActivity

        val message = args.message

        //changement du titre et du logo en fonction du bouton cliqué.
        if (message == "facebook") {
            binding.loginLogo.setImageResource(R.drawable.facebook)
            activity.supportActionBar?.title = "FacebookLogin"
        } else {
            binding.loginLogo.setImageResource(R.drawable.twitter)
            activity.supportActionBar?.title = "TwitterLogin"
        }

        binding.SignInButton.setOnClickListener {
            if (binding.emailEditText.text.toString().isEmpty() || binding.passwordEditText.text.toString().isEmpty()) {
                AlertDialog.Builder(requireContext())
                    .setTitle("Erreur")
                    .setMessage("Login incomplet")
                    .setPositiveButton("OK") { dialog, which ->
                        dialog.cancel()
                    }
                    .show()
            } else {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSuccessfulLoginFragment(message, ""))
            }
        }


    }

}