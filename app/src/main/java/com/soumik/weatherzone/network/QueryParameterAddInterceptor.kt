package com.soumik.weatherzone.network

import com.soumik.weatherzone.ui.base.WeatherZone
import com.soumik.weatherzone.utils.APP_ID
import com.soumik.weatherzone.utils.PrefManager
import okhttp3.Interceptor
import okhttp3.Response

class QueryParameterAddInterceptor:Interceptor {

    val context = WeatherZone.context
    private val prefManager = PrefManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url().newBuilder()
            .addQueryParameter("appid", APP_ID)
            .addQueryParameter("units",prefManager.tempUnit)
            .build()

        val request = chain.request().newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}