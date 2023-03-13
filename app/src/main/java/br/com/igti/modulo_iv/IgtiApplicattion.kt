package br.com.igti.modulo_iv

import android.app.Application
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class IgtiApplicattion : Application() {

    companion object {
        lateinit var retrofit : Retrofit
    }

    override fun onCreate() {
        super.onCreate()

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15L)
            .readTimeout(15L)
            .writeTimeout(15L)
            .build()

        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://igti.com.br")
            .build()
    }

}