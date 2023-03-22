package br.com.igti.modulo_iv.data.remote

import br.com.igti.modulo_iv.data.remote.dto.AlunoRequestDTO
import br.com.igti.modulo_iv.data.remote.dto.AlunoResponseDTO
import br.com.igti.modulo_iv.data.remote.dto.MessageDTO
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Path

class AlunoRepository(private val retrofitClient: RetrofitClient) : IAlunoRepository {
    override fun listarAlunos() : Call<List<AlunoResponseDTO>> =
        retrofitClient.getInstance().getAlunoApi()!!.listarAlunos()

    override fun alunoPorId(@Path(value = "id") id: String): Call<AlunoResponseDTO> {
        TODO("Not yet implemented")
    }

    override fun cadastrarAluno(@Body aluno: AlunoRequestDTO): Call<AlunoResponseDTO> {
        TODO("Not yet implemented")
    }

    override fun alterarAluno(
        @Path(value = "id") id: String,
        @Body aluno: AlunoRequestDTO
    ): Call<AlunoResponseDTO> {
        TODO("Not yet implemented")
    }

    override fun excluirAluno(@Path(value = "id") id: String): Call<Response> {
        TODO("Not yet implemented")
    }

    override fun helloWorld(): Call<MessageDTO> {
        TODO("Not yet implemented")
    }


}