package br.com.igti.modulo_iv.data.remote

import br.com.igti.modulo_iv.data.remote.dto.AlunoRequestDTO
import br.com.igti.modulo_iv.data.remote.dto.AlunoResponseDTO
import br.com.igti.modulo_iv.data.remote.dto.MessageDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IAlunoRepository {
    @GET("/alunos")
    fun listarAlunos() : Call<List<AlunoResponseDTO>>

    @GET("/alunos/{id}")
    fun alunoPorId() : Call<AlunoResponseDTO>

    @POST("/alunos")
    fun cadastrarAluno(@Body aluno : AlunoRequestDTO) : Call<AlunoResponseDTO>

    fun alterarAluno()

    fun excluirAluno()

    @GET("/helloworld")
    fun helloWorld() : Call<MessageDTO>
}