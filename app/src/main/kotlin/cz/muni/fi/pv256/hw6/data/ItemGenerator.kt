package cz.muni.fi.pv256.hw6.data

import com.thedeanda.lorem.LoremIpsum

class ItemGenerator {
    companion object {
        fun generate(count: Int): List<Item> {
            if (count < 1) {
                throw IllegalArgumentException("count must be >= 1")
            }
            val lorem = LoremIpsum.getInstance()
            val list = ArrayList<Item>(count)
            for (i in 0 until count) {
                list.add(Item("Title $i", lorem.getWords(10, 50)))
            }
            return list
        }
    }
}
