package br.com.igti.modulo_iv.data.remote

import br.com.igti.modulo_iv.IgtiApplicattion
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val retrofitClient : RetrofitClient? = null

    private fun createOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(15L, TimeUnit.SECONDS)
            .readTimeout(15L, TimeUnit.SECONDS)
            .writeTimeout(15L, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor { msg ->
                println("LOG APP: $msg")
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).addNetworkInterceptor(HttpLoggingInterceptor { msg ->
                println("LOG NTW: $msg")
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    private fun createRetrofitInstance() {
        IgtiApplicattion.retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://igtiandroid.ddns.net:8080")
            .client(createOkHttpClient())
            .build()

        IgtiApplicattion.retrofit.create(IAlunoRepository::class.java)
    }

}