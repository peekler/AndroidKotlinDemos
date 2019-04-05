package hu.bme.aut.android.kotifydemo.interactor

import dagger.Module
import dagger.Provides
import hu.bme.aut.android.kotifydemo.interactor.artists.ArtistsInteractor
import hu.bme.aut.android.kotifydemo.network.ArtistsApi
import hu.bme.aut.android.kotifydemo.network.TokenApi
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideArtistsInteractor(artistsApi: ArtistsApi, tokenApi: TokenApi) = ArtistsInteractor(artistsApi, tokenApi)
}
