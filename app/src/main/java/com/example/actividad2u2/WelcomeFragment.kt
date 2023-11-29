package com.example.actividad2u2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import com.example.actividad2u2.databinding.FragmentTermsBinding
import com.example.actividad2u2.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var _binding: FragmentWelcomeBinding
    private val binding: FragmentWelcomeBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.but1.setOnClickListener { navigateNext() }
    }

    private fun navigateNext() {
        val nombre = binding.nombreText1.text.toString()
        val categoria = obtenerCategoriaSeleccionada()

        // Crear una instancia de TermsFragment y pasar datos
        val secondFragment = TermsFragment.newInstance(nombre, categoria)

        // Reemplazar el fragmento actual con TermsFragment
        parentFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainerView, secondFragment)
            .addToBackStack("TermsFragment")
            .commit()
    }

    private fun obtenerCategoriaSeleccionada(): String {
        return when {
            binding.checkBox.isChecked -> getString(R.string.cb1)
            binding.checkBox2.isChecked -> getString(R.string.cb2)
            binding.checkBox3.isChecked -> getString(R.string.cb3)
            else -> ""  // Otra lógica según tus necesidades
        }
    }
}


