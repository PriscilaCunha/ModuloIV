package br.com.igti.modulo_iv.data.remote

interface IAlunoRepository {

    fun getAlunos() : List<String>
}