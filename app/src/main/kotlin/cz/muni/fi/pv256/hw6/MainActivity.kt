package cz.muni.fi.pv256.hw6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cz.muni.fi.pv256.hw6.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, MainFragment.newInstance())
                .commitNow()
        }
    }
}
