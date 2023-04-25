package com.br.ipapp.network

import com.br.ipapp.networkmodel.IpResponse
import retrofit2.Response
import retrofit2.http.GET

interface IpApi {
    @GET()
    suspend fun getClientIpInfo(
    ): Response<IpResponse>
}