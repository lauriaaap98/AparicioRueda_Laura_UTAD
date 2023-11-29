import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.actividad2u2.New
import com.example.actividad2u2.databinding.ItemRvNoticias1Binding

class NewRecyclerViewAdapter(
    private var newList: List<New>,
    private val onClick: (New) -> Unit
) : RecyclerView.Adapter<NewRecyclerViewAdapter.NewViewHolder>() {

    inner class NewViewHolder(val binding: ItemRvNoticias1Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvNoticias1Binding.inflate(inflater, parent, false)
        return NewViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newList.size // Devuelve el tamaño de la lista
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        // Obtén el objeto New en la posición actual
        val currentNew = newList[position]

        // Configura las vistas en el ViewHolder con las propiedades de currentNew
        holder.binding.root.setOnClickListener { onClick(currentNew) }
        holder.binding.tituloNotGen1.text = currentNew.titulo
        holder.binding.fechaNotGen2.text = currentNew.fecha
    }

    // Método para actualizar la lista de noticias
    fun updateList(newList: List<New>) {
        this.newList = newList
        notifyDataSetChanged()
    }
}