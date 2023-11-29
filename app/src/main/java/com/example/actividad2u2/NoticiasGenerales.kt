package com.example.actividad2u2

import NewRecyclerViewAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.actividad2u2.databinding.FragmentNoticiasGeneralesBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class NoticiasGenerales : Fragment() {
    private lateinit var _binding: FragmentNoticiasGeneralesBinding
    private val binding: FragmentNoticiasGeneralesBinding get() = _binding
    private lateinit var adapter: NewRecyclerViewAdapter
    private lateinit var combinedList: MutableList<New> // Lista para almacenar noticias combinadas

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoticiasGeneralesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerIdNotGen.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        combinedList = mutableListOf()

        // Configura el adaptador
        val list = getNewsList()
        adapter = NewRecyclerViewAdapter(list) { sayMyName(it) }
        binding.recyclerIdNotGen.adapter = adapter

        // Configura el FloatingActionButton

        val fabAgregarNoticias = view.findViewById<FloatingActionButton>(R.id.fabAgregarNoticias)
        fabAgregarNoticias.setOnClickListener {
            // Obtén las listas de noticias de otras categorías (simuladas)
            val listDeportes: List<Deporte> = getDeportesList()
            val listTecnologia: List<Tecnologia> = getTecnologiaList()

            // Combina las listas
            val combinedList = mutableListOf<New>()
            combinedList.addAll(listDeportes.map { it.toNew() })
            combinedList.addAll(listTecnologia.map { it.toNew() })

            // Agrega las noticias combinadas al inicio de la lista original
            combinedList.addAll(0, list)

            // Actualiza la RecyclerView con la lista combinada
            adapter.updateList(combinedList)
        }
    }




    private fun sayMyName(new: New) {
        Toast.makeText(requireContext(), new.titulo, Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getNewsList(): List<New> {
        val listGenerales = listOf(
            New(
                "Muere la famosa Medallista",
                "20 de noviembre de 2023",
                R.drawable.emiliamedallista
            ),
            New(
                "Aitana gana el disco de oro",
                "26 de septiembre de 2023",
                R.drawable.aitana
            ),
            New(
                "Un jugador de Minecraft construye una nave de StarTreck en el juego",
                "25 de noviembre de 2023",
                R.drawable.navestartreck

            ),
            New(
                "Rafaela Carra regresa en forma de Docuserie",
                "22 de noviembre de 2023",
                R.drawable.rafaelacarra
            ),
            New(
                "La web que te dice cuánto valdrías si vivieras en un capítulo de ‘Black Mirror’",
                "22 de noviembre de 2023",
                R.drawable.blackmirror
            ),
        )

        // Puedes agregar más noticias generales aquí

        return listGenerales
    }

    private fun getDeportesList(): List<Deporte> {
        // Implementa la obtención de noticias de deportes (simulada)
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
            // Puedes agregar más noticias de deportes aquí
        )
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getTecnologiaList(): List<Tecnologia> {
        // Implementa la obtención de noticias de tecnología (simulada)
        return listOf(
            Tecnologia(
                "España se jugará la plaza olímpica con Líbano, Angola, Finlandia, Polonia y Bahamas",
                "20 de noviembre de 2023",
                R.drawable.baloncestoolimp
            ),
            Tecnologia(
                "Alexia causa baja en la Selección y vuelve a Barcelona",
                "12 de septiembre de 2023",
                R.drawable.alexia
            ),
            // Puedes agregar más noticias de tecnología aquí
        )
    }
}