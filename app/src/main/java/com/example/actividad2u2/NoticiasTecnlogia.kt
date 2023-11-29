package com.example.actividad2u2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.actividad2u2.databinding.FragmentNoticiasTecnlogiaBinding

class NoticiasTecnologia : Fragment() {
    private lateinit var _binding: FragmentNoticiasTecnlogiaBinding
    private val binding: FragmentNoticiasTecnlogiaBinding get() = _binding
    private lateinit var adapter: NewRecyclerViewAdapterTec

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoticiasTecnlogiaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerIdNoTec.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val listTec = getTecList()

        adapter = NewRecyclerViewAdapterTec(listTec) { sayMyName(it) }
        binding.recyclerIdNoTec.adapter = adapter
    }

    private fun sayMyName(tec: Tecnologia) {
        // Implementa lo que quieras hacer cuando se hace clic en una noticia de tecnología
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getTecList(): List<Tecnologia> {
        return listOf(
            Tecnologia(
                "El efecto TikTok en el turismo: cuando la viralidad es indeseable",
                "20 de noviembre de 2023",
                R.drawable.efectotiktok
            ),
            Tecnologia(
                "El dinero impone su ley en OpenAI",
                "12 de septiembre de 2023",
                R.drawable.openai
            )
        )

    }
}