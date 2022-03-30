package cz.muni.fi.pv256.hw6.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import cz.muni.fi.pv256.hw6.R
import cz.muni.fi.pv256.hw6.data.Item
import cz.muni.fi.pv256.hw6.databinding.MainFragmentBinding
import cz.muni.fi.pv256.hw6.ui.detail.DetailActivity
import cz.muni.fi.pv256.hw6.ui.detail.DetailActivity.Companion.ITEM

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MainAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MainAdapter { item -> adapterOnClick(item) }
        binding.recyclerView.apply {
            val itemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
            addItemDecoration(itemDecoration)
            adapter = this@MainFragment.adapter
        }

        viewModel.items.observe(
            viewLifecycleOwner,
            {
                adapter.items = it
            }
        )

        binding.fab.setOnClickListener { fabOnClick() }
    }

    private fun adapterOnClick(item: Item) {
        val intent = Intent(context, DetailActivity()::class.java)
        intent.putExtra(ITEM, item)
        startActivity(intent)
    }

    private fun fabOnClick() {
        viewModel.generateNewItems((11..21).random())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
