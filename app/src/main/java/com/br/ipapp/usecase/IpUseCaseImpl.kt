package com.br.ipapp.usecase

import com.br.ipapp.network.Resource
import com.br.ipapp.networkmodel.IpResponse
import com.br.ipapp.repository.IpRepository
import javax.inject.Inject

class IpUseCaseImpl @Inject constructor(
    private val ipRepository: IpRepository,
) : IpUseCase {
    override suspend fun getIpData(): Resource<IpResponse> {
        val result = ipRepository.getIpData()
        return when (result) {
            is Resource.Success -> result
            is Resource.Error -> result
        }
    }
}