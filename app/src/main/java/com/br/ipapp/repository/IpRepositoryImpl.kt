package com.br.ipapp.repository

import com.br.ipapp.network.IpApi
import com.br.ipapp.network.Resource
import com.br.ipapp.networkmodel.IpResponse
import javax.inject.Inject

class IpRepositoryImpl @Inject constructor(private val ipApi: IpApi) : IpRepository {
    override suspend fun getIpData(): Resource<IpResponse> {
        return try {
            Resource.Success(data = ipApi.getClientIpInfo().body() ?: IpResponse())
        } catch (e: Exception) {
            Resource.Error(message = e.stackTrace.toString())
        }
    }
}