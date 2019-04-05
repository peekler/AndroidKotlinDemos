package hu.bme.aut.android.kotifydemo

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.aut.android.kotifydemo.interactor.artists.ArtistsInteractor
import hu.bme.aut.android.kotifydemo.ui.artists.ArtistsPresenter
import hu.bme.aut.android.kotifydemo.ui.main.MainPresenter
import hu.bme.aut.android.kotifydemo.utils.UiExecutor
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideMainPresenter() = MainPresenter()

    @Provides
    @Singleton
    fun provideArtistsPresenter(executor: Executor, artistsInteractor: ArtistsInteractor) = ArtistsPresenter(executor, artistsInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}
