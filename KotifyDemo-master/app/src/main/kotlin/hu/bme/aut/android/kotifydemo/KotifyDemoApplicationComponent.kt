package hu.bme.aut.android.kotifydemo

import dagger.Component
import hu.bme.aut.android.kotifydemo.interactor.InteractorModule
import hu.bme.aut.android.kotifydemo.network.NetworkModule
import hu.bme.aut.android.kotifydemo.ui.UIModule
import hu.bme.aut.android.kotifydemo.ui.artists.ArtistsFragment
import hu.bme.aut.android.kotifydemo.ui.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface KotifyDemoApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(artistsFragment: ArtistsFragment)
}
