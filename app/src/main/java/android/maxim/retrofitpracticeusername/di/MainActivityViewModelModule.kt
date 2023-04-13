package android.maxim.retrofitpracticeusername.di

import android.maxim.retrofitpracticeusername.ui.MainActivity
import androidx.lifecycle.MutableLiveData
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

    @ViewModelScoped
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(MainActivity.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @ViewModelScoped
    @Provides
    fun provideLiveData(): MutableLiveData<String> {
        return MutableLiveData()
    }
}