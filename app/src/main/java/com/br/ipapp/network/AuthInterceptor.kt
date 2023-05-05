package com.br.ipapp.network

import com.br.ipapp.datastore.DataStoreManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val dataStoreManager: DataStoreManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val key = runBlocking {
            dataStoreManager.getKey().first()
        }
        try {
            val url = chain
                .request()
                .url
                .newBuilder()
                .addQueryParameter("key", key)
                .build()
            req = req.newBuilder().url(url).build()
            chain.proceed(req)
        } catch (ex: Exception) {
            throw Exception(ex)
        }
        return chain.proceed(req)
    }
}