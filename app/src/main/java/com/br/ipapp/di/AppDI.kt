package com.br.ipapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.br.ipapp.BuildConfig
import com.br.ipapp.datastore.DataStoreManager
import com.br.ipapp.network.AuthInterceptor
import com.br.ipapp.network.IpApi
import com.br.ipapp.util.Constant.PREFERENCES
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDI {

    @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext appContext: Context, authInterceptor:AuthInterceptor): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
        //httpBuilder.addInterceptor(NetworkInterceptor(appContext))
        httpBuilder.addInterceptor(authInterceptor)

        return if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpBuilder
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).addInterceptor(loggingInterceptor)
                .build()
        } else {
            httpBuilder.build()
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val baseApiUrl = "https://ipapi.co/"
        return Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl(baseApiUrl)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideIpApi(retrofit: Retrofit): IpApi {
        return retrofit.create(IpApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthInterceptor(dataStoreManager:DataStoreManager):AuthInterceptor{
        return AuthInterceptor(dataStoreManager)
    }

    @Singleton
    @Provides
    fun providePreferencesDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ),
            migrations = listOf(SharedPreferencesMigration(appContext, PREFERENCES)),
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { appContext.preferencesDataStoreFile(PREFERENCES) }
        )
    }
}