package br.com.igti.modulo_iv.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.igti.modulo_iv.data.remote.AlunoRepository
import br.com.igti.modulo_iv.data.remote.IAlunoRepository
import br.com.igti.modulo_iv.data.remote.RetrofitClient
import br.com.igti.modulo_iv.data.remote.dto.AlunoRequestDTO
import br.com.igti.modulo_iv.data.remote.dto.AlunoResponseDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlunoViewModel(
    // Dispatchers.IO indicates that the coroutine will be executed on a thread reserved for I/O (Input/Output) operations.
    // IO is the recommended when you do DataBase operations
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val repository : IAlunoRepository = AlunoRepository(RetrofitClient())

    // "_" in the beginning to identify the variable as private
    //private val _listaAlunos : MutableLiveData<List<AlunoResponseDTO>> = MutableLiveData()
    //val listaAlunos : LiveData<List<AlunoResponseDTO>> = _listaAlunos

    // Google is recommending the use of Flow instead of LiveData
    private val _listaAlunosFlow = MutableStateFlow<List<AlunoResponseDTO>>(listOf())
    val listaAlunosFlow : StateFlow<List<AlunoResponseDTO>> = _listaAlunosFlow

    fun listarAlunos() {
        // ViewModelScope will identify and remove the coroutines in its scope if the ViewModel is removed. This helps the code to be asynchronous
        viewModelScope.launch(dispatcher) {
            repository.listarAlunos().enqueue(object : Callback<List<AlunoResponseDTO>>{
                override fun onResponse(
                    call: Call<List<AlunoResponseDTO>>,
                    response: Response<List<AlunoResponseDTO>>
                ) {
                    if(response.isSuccessful) {
                        response.body()?.let { list ->
                            _listaAlunosFlow.value = list
                        }
                    }
                }

                override fun onFailure(call: Call<List<AlunoResponseDTO>>, t: Throwable) {
                    _listaAlunosFlow.value = listOf()
                    Log.e(AlunoViewModel::class.java.name, t.toString())
                }
            })

            //_listaAlunos.value = listaDeAlunos
            //_listaAlunosFlow.value = listaAlunosFlow
        }
        //TODO repository.get()
    }

    fun listarAlunoPorId(id : String) {
        //TODO repository.getById(id)
    }

    fun cadastrarAluno(aluno : AlunoRequestDTO) {
        //TODO repository.post(aluno)
    }

    fun alterarAluno(id : String, aluno : AlunoRequestDTO) {
        //TODO repository.put(id, aluno)
    }

    fun excluirAluno(id : String) {
        //TODO repository(delete(id)
    }
}
