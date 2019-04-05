package hu.bme.aut.android.kotifydemo

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.bme.aut.android.kotifydemo.interactor.artists.ArtistsInteractor
import hu.bme.aut.android.kotifydemo.ui.UIModule
import hu.bme.aut.android.kotifydemo.ui.artists.ArtistsPresenter
import hu.bme.aut.android.kotifydemo.ui.main.MainPresenter
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class AndroidTestModule(context: Context) {

    private val uiModule: UIModule = UIModule(context)

    @Provides
    fun provideContext(): Context {
        return uiModule.context()
    }

    @Provides
    @Singleton
    fun provideMainPresenter(): MainPresenter {
        return uiModule.mainPresenter()
    }

    @Provides
    @Singleton
    fun provideArtistsPresenter(executor: Executor, artistsInteractor: ArtistsInteractor): ArtistsPresenter {
        return uiModule.artistsPresenter(executor, artistsInteractor)
    }

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor {
        return uiModule.networkExecutor()
    }

}
