package android.maxim.retrofitpracticeusername.di

import android.maxim.retrofitpracticeusername.ui.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class MainActivityViewModelModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(MainActivity.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}