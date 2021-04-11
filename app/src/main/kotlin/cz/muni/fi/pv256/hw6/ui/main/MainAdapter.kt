package cz.muni.fi.pv256.hw6.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cz.muni.fi.pv256.hw6.data.Item
import cz.muni.fi.pv256.hw6.databinding.ListItemBinding

class MainAdapter(private val onClick: (Item) -> Unit) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    // TODO implement data refresh
    var items = listOf<Item>()

    class ViewHolder(itemBinding: ListItemBinding, val onClick: (Item) -> Unit) :
        RecyclerView.ViewHolder(itemBinding.root) {

        // TODO implement ViewHolder and its binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Create instance of ViewHolder")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Bind ViewHolder")
    }

    override fun getItemCount(): Int {
        TODO("Implement item count")
    }
}
