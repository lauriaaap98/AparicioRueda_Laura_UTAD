package com.example.actividad2u2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.actividad2u2.databinding.FragmentTermsBinding
import com.example.actividad2u2.databinding.FragmentWelcomeBinding
import java.security.PrivateKey


class TermsFragment : Fragment() {
    private lateinit var _binding: FragmentTermsBinding
    private val binding: FragmentTermsBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTermsBinding.inflate(inflater, container, false)

        val nombre = arguments?.getString("nombreText1")
        val categoria = arguments?.getString("categoria")

        binding.mensajeAviso.text = getString(R.string.mensajeF2, nombre)

        binding.but2.setOnClickListener { navigateNext() }

        return binding.root
    }

    private fun navigateNext() {
        val nombre = arguments?.getString("nombre")
        val categoria = arguments?.getString("categoria")

        val intent = Intent(requireContext(), ActivityHome::class.java).apply {
            putExtra("nombre", nombre)
            putExtra("categoria", categoria)
        }

        startActivity(intent)
    }

    companion object {
        fun newInstance(nombre: String, categoria: String): TermsFragment {
            val args = Bundle()
            args.putString("nombreText1", nombre)
            args.putString("categoria", categoria)

            val fragment = TermsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    }


