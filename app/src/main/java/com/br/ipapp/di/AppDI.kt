package com.br.ipapp.di

import android.content.Context
import com.br.ipapp.BuildConfig
import com.br.ipapp.network.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDI {

    @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext appContext: Context): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
        //httpBuilder.addInterceptor(NetworkInterceptor(appContext))
        httpBuilder.addInterceptor(AuthInterceptor())

        return if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpBuilder
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build()
        } else {
            httpBuilder.build()
        }
    }

}