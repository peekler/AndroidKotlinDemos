package hu.bme.aut.android.kotifydemo.ui.main

import hu.bme.aut.android.kotifydemo.ui.Presenter

class MainPresenter : Presenter<MainScreen>() {

    fun showArtistsSearchList(artistSearchTerm: String) {
        screen?.showArtists(artistSearchTerm)
    }
}
