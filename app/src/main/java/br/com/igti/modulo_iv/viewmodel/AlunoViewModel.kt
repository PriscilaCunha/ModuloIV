package br.com.igti.modulo_iv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.igti.modulo_iv.data.remote.dto.AlunoRequestDTO
import br.com.igti.modulo_iv.data.remote.dto.AlunoResponseDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime

class AlunoViewModel(
    // Dispatchers.IO indicates that the coroutine will be executed on a thread reserved for I/O (Input/Output) operations.
    // IO is the recommended when you do DataBase operations
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    // "_" in the beginning to identify the variable as private
    private val _listaAlunos : MutableLiveData<List<AlunoResponseDTO>> = MutableLiveData()
    val listaAlunos : LiveData<List<AlunoResponseDTO>> = _listaAlunos

    private val _listaAlunosFlow : MutableStateFlow<List<AlunoResponseDTO>>(listOf())
    val listaAlunosFlow : StateFlow<List<AlunoResponseDTO>> = _listaAlunosFlow

    fun listarAlunos() {
        // ViwModelScope will identify and remove the coroutines in its scope if the ViewModel is removed
        // This helps the code to be asynchronous
        viewModelScope.launch(dispatcher) {
            val listaDeAlunos = listOf(
                AlunoResponseDTO(
                    id = "a123",
                    nome = "Priscila",
                    sobrenome = "Cunha",
                    nascimento = LocalDate.parse("1990-12-08"),
                    cadastro = LocalDateTime.now()
                ),
                AlunoResponseDTO(
                    id = "a124",
                    nome = "Jeferson",
                    sobrenome = "Nascimento",
                    nascimento = LocalDate.parse("1988-05-09"),
                    cadastro = LocalDateTime.now()
                )
            )

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
