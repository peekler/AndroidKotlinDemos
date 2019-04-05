package hu.bme.aut.android.kotifydemo

import dagger.Component
import hu.bme.aut.android.kotifydemo.interactor.InteractorModule
import hu.bme.aut.android.kotifydemo.mock.MockNetworkModule
import hu.bme.aut.android.kotifydemo.test.ArtistsTest
import hu.bme.aut.android.kotifydemo.test.MainTest
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : KotifyDemoApplicationComponent {
    fun inject(artistsTest: ArtistsTest)
    fun inject(mainTest: MainTest)
}
