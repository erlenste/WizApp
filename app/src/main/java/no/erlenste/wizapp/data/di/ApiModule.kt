package no.erlenste.wizapp.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import no.erlenste.wizapp.data.datasource.WizDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideWizDataSource(httpClient: HttpClient): WizDataSource {
        return WizDataSource(httpClient)
    }
}