package br.com.igti.modulo_iv.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface IAlunoRepository {

    @GET
    fun getAlunos() : Call<List<String>>

}