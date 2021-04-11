package cz.muni.fi.pv256.hw6.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cz.muni.fi.pv256.hw6.data.Item
import cz.muni.fi.pv256.hw6.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ITEM = "item"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.apply {
            val item = getParcelable<Item>(ITEM)
            binding.title.text = item?.title
            binding.text.text = item?.text
        }
    }
}
