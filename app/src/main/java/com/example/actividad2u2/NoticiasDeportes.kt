package com.example.actividad2u2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.actividad2u2.databinding.FragmentNoticiasDeportesBinding

class NoticiasDeportes : Fragment() {
    private lateinit var _binding: FragmentNoticiasDeportesBinding
    private val binding: FragmentNoticiasDeportesBinding get() = _binding
    private lateinit var adapter: NewRecyclerViewAdapterDep

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoticiasDeportesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerIdNotDep.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val listDep = getDepList()

        adapter = NewRecyclerViewAdapterDep(listDep) { sayMyName(it) }
        binding.recyclerIdNotDep.adapter = adapter
    }

    private fun sayMyName(dep: Deporte) {
        Toast.makeText(requireContext(), dep.titulo, Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getDepList(): List<Deporte> {
        return listOf(
            Deporte(
                "España se jugará la plaza olímpica con Líbano, Angola, Finlandia, Polonia y Bahamas",
                "20 de noviembre de 2023",
                R.drawable.baloncestoolimp
            ),
            Deporte(
                "Alexia causa baja en la Selección y vuelve a Barcelona",
                "12 de septiembre de 2023",
                R.drawable.alexia
            ),
            Deporte(
                "Oficial: MotoGP recupera las concesiones para ayudar a Honda y Yamaha",
                "22 de noviembre de 2023",
                R.drawable.motogp
            ),
            Deporte(
                "Bagnaia reconoce que \"quería conseguir el título ganando la carrera\"",
                "21 de noviembre de 2023",
                R.drawable.motos2
            )
        )
    }
}