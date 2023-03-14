package br.com.igti.modulo_iv.data.remote

import br.com.igti.modulo_iv.data.remote.dto.AlunoRequestDTO
import br.com.igti.modulo_iv.data.remote.dto.AlunoResponseDTO
import br.com.igti.modulo_iv.data.remote.dto.MessageDTO
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface IAlunoRepository {
    @GET("/alunos")
    fun listarAlunos() : Call<List<AlunoResponseDTO>>

    @GET("/alunos/{id}")
    fun alunoPorId() : Call<AlunoResponseDTO>

    @POST("/alunos")
    fun cadastrarAluno(@Body aluno : AlunoRequestDTO) : Call<AlunoResponseDTO>

    @PUT("/alunos/{id}")
    fun alterarAluno(@Body aluno: AlunoRequestDTO) : Call<AlunoResponseDTO>

    @DELETE("/alunos/{id}")
    fun excluirAluno() : Call<Response>

    @GET("/helloworld")
    fun helloWorld() : Call<MessageDTO>
}