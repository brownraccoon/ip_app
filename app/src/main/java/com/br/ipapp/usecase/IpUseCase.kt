package com.br.ipapp.usecase

import com.br.ipapp.network.Resource
import com.br.ipapp.networkmodel.IpResponse

interface IpUseCase {
    suspend fun getIpData(): Resource<IpResponse>
}