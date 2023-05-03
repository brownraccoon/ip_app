package com.br.ipapp.di

import com.br.ipapp.network.IpApi
import com.br.ipapp.repository.IpRepository
import com.br.ipapp.repository.IpRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryDI {

    @Provides
    fun provideIpRepository(
        apiService: IpApi
    ): IpRepository {
        return IpRepositoryImpl(apiService)
    }
}