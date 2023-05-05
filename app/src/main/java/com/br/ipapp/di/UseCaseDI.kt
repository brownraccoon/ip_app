package com.br.ipapp.di

import com.br.ipapp.repository.IpRepository
import com.br.ipapp.usecase.IpUseCase
import com.br.ipapp.usecase.IpUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseDI {
    @Provides
    @ViewModelScoped
    fun provideIpUseCase(
        ipRepository: IpRepository
    ): IpUseCase {
        return IpUseCaseImpl(
            ipRepository
        )

    }
}

