package com.example.actividad2u2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.actividad2u2.databinding.ItemRvNoticias1Binding
import com.example.actividad2u2.databinding.ItemRvTecnologiaBinding

class NewRecyclerViewAdapterTec(
    private val newList: List<Tecnologia>,
    private val onClick: (Tecnologia) -> Unit
) : RecyclerView.Adapter<NewRecyclerViewAdapterTec.NewViewHolder>() {

    inner class NewViewHolder(val binding: ItemRvTecnologiaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvTecnologiaBinding.inflate(inflater, parent, false)
        return NewViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        val currentTec = newList[position]

        holder.binding.root.setOnClickListener { onClick(currentTec) }
        holder.binding.tituloNotTec1.text = currentTec.titulo
        holder.binding.fechaNotTec3.text = currentTec.fecha
    }
}