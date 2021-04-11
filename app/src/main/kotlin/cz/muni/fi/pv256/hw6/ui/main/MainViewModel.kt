package cz.muni.fi.pv256.hw6.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cz.muni.fi.pv256.hw6.data.Item
import cz.muni.fi.pv256.hw6.data.ItemGenerator

class MainViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Item>>().apply { value = ItemGenerator.generate(10) }

    val items: LiveData<List<Item>>
        get() = _items

    fun generateNewItems(count: Int) {
        _items.value = ItemGenerator.generate(count)
    }
}
