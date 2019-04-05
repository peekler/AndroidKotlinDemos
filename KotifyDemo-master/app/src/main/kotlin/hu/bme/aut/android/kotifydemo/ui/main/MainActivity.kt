package hu.bme.aut.android.kotifydemo.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hu.bme.aut.android.kotifydemo.R
import hu.bme.aut.android.kotifydemo.injector
import hu.bme.aut.android.kotifydemo.ui.artists.ArtistsActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)

        btnShowArtists.setOnClickListener {
            mainPresenter.showArtistsSearchList(etArtist.text.toString()) }
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    override fun showArtists(artistSearchTerm: String) {
        val intent = Intent(this, ArtistsActivity::class.java)
        intent.putExtra(KEY_ARTIST, artistSearchTerm)
        startActivity(intent)
    }

    companion object {
        const val KEY_ARTIST = "KEY_ARTIST"
    }
}
