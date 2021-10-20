package com.laitec.digikala.network

import fahimeh.eltejaei.mydigikala.db.SharedPrefRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthInterceptor @Inject constructor(private val sharedPrefs: SharedPrefRepository) :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = runBlocking { sharedPrefs.getToken() }
        var req = chain.request()
        if (token != null) {
            req = req.newBuilder().addHeader("Authorization", token).build()
        }
        return chain.proceed(req)
    }
}