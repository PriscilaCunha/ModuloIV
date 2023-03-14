package br.com.igti.modulo_iv.data.remote

import br.com.igti.modulo_iv.data.remote.dto.MessageDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IAlunoRepository {

    fun listarAlunos()

    fun alunoPorId()

    fun cadastrarAluno()

    fun alterarAluno()

    fun excluirAluno()

    @GET
    @Path("/helloworld")
    fun helloWorld() : Call<MessageDTO>
}