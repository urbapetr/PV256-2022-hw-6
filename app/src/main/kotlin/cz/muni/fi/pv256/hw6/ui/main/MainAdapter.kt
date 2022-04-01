package cz.muni.fi.pv256.hw6.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cz.muni.fi.pv256.hw6.data.Item
import cz.muni.fi.pv256.hw6.databinding.ListItemBinding

class MainAdapter(private val onClick: (Item) -> Unit) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var items = listOf<Item>()
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(itemBinding: ListItemBinding, val onClick: (Item) -> Unit) :
        RecyclerView.ViewHolder(itemBinding.root) {

        private val title = itemBinding.title
        private val text = itemBinding.text

        fun bind(item: Item) {
            title.text = item.title
            text.text = item.text
            itemView.setOnClickListener { onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
