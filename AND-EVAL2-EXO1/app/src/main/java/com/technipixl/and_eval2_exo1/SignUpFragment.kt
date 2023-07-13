package com.technipixl.and_eval2_exo1

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.technipixl.and_eval2_exo1.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as AppCompatActivity
        activity.supportActionBar?.title = "SignUp"

        binding.SignUpButton.setOnClickListener {
            if (!binding.emailEditText.text.toString().contains('@') || binding.emailEditText.text.toString().isEmpty()) {
                alertDialogDisplay("L'email est invalide.")
            } else if (binding.loginEditText.text.toString().isEmpty()) {
                alertDialogDisplay("Le login n'a pas été rempli.")
            } else if (binding.passwordEditText.text.toString() != binding.confirmationEditText.text.toString()) {
                alertDialogDisplay("Les mots de passe ne correspondent pas.")
            } else {
                findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToSuccessfulLoginFragment("bloggies", binding.loginEditText.text.toString()))
            }
        }
    }

    fun alertDialogDisplay(message: String) {
        AlertDialog.Builder(requireContext())
            .setTitle("Erreur")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, which ->
                dialog.cancel()
            }
            .show()
    }


}