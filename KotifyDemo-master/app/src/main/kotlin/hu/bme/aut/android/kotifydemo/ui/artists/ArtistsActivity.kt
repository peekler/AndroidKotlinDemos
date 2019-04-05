package hu.bme.aut.android.kotifydemo.ui.artists

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import hu.bme.aut.android.kotifydemo.R
import hu.bme.aut.android.kotifydemo.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_artists.*

class ArtistsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artists)
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction().replace(R.id.fragment, ArtistsFragment.newInstance(intent.getStringExtra(MainActivity.KEY_ARTIST))).commit()
        fab.setOnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
    }
}
