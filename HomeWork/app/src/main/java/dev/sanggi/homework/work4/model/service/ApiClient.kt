package dev.sanggi.homework.work4.model.service

import android.util.TimeUtils
import dev.sanggi.homework.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val REQUEST_TIMEOUT = 60
    private val baseURL = "https://api.github.com/"
    private var retrofit: Retrofit
    private var logging = HttpLoggingInterceptor()

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getHttpLogClient())
            .build()
    }

    private fun getHttpLogClient(): OkHttpClient {
        val httpClient = OkHttpClient().newBuilder()
            .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)

        if (BuildConfig.DEBUG)
            logging.level = HttpLoggingInterceptor.Level.BODY

        httpClient.addInterceptor(logging)
        return httpClient.build()
    }

    fun getService(): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

}