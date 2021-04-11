package cz.muni.fi.pv256.hw6.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import cz.muni.fi.pv256.hw6.R
import cz.muni.fi.pv256.hw6.data.Item
import cz.muni.fi.pv256.hw6.ui.detail.DetailActivity
import cz.muni.fi.pv256.hw6.ui.detail.DetailActivity.Companion.ITEM

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    // TODO add MainFragmentBinding and don't forget to deinit it later

    private lateinit var adapter: MainAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // TODO refactor to use view binding
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO init adapter with RecyclerView
        // use adapterOnClick function when creating the RecyclerView
        // apply vertical DividerItemDecoration

        viewModel.items.observe(
            viewLifecycleOwner,
            {
                adapter.items = it
            }
        )

        // TODO refactor to use view binding
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { fabOnClick() }
    }

    private fun adapterOnClick(item: Item) {
        val intent = Intent(context, DetailActivity()::class.java)
        intent.putExtra(ITEM, item)
        startActivity(intent)
    }

    private fun fabOnClick() {
        viewModel.generateNewItems((11..21).random())
    }
}
