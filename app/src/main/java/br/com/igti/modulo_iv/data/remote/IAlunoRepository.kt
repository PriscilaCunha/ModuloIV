package br.com.igti.modulo_iv.data.remote

interface IAlunoRepository {

    fun listarAlunos()

    fun alunoPorId()

    fun cadastrarAluno()

    fun alterarAluno()

    fun excluirAluno()

}