package com.example.actividad2u2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.actividad2u2.databinding.ItemRvNoticias1Binding

class NewRecyclerViewAdapterDep(
    private val newList: List<Deporte>,
    private val onClick: (Deporte) -> Unit
) : RecyclerView.Adapter<NewRecyclerViewAdapterDep.NewViewHolder>() {

    inner class NewViewHolder(val binding: ItemRvNoticias1Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvNoticias1Binding.inflate(inflater, parent, false)
        return NewViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        val currentDep = newList[position]

        holder.binding.root.setOnClickListener { onClick(currentDep) }
        holder.binding.tituloNotGen1.text = currentDep.titulo
        holder.binding.fechaNotGen2.text = currentDep.fecha
    }
}