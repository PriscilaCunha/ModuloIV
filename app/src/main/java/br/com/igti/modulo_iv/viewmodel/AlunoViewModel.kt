package br.com.igti.modulo_iv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.igti.modulo_iv.data.remote.dto.AlunoRequestDTO
import br.com.igti.modulo_iv.data.remote.dto.AlunoResponseDTO

class AlunoViewModel : ViewModel() {

    private val _listaAlunos : MutableLiveData<List<AlunoResponseDTO>> = MutableLiveData()
    val listaAlunos : LiveData<List<AlunoResponseDTO>> = _listaAlunos

    fun listarAlunos() {
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
