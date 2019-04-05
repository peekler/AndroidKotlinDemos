package hu.bme.aut.android.kotifydemo

import android.app.Application
import hu.bme.aut.android.kotifydemo.ui.UIModule

class KotifyDemoApplication : Application() {
    lateinit var injector: KotifyDemoApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerKotifyDemoApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}
