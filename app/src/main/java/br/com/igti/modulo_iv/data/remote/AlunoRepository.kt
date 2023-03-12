package br.com.igti.modulo_iv.data.remote

class AlunoRepository : IAlunoRepository {

    override fun getAlunos(): List<String> {
        return listOf("123.456.789.12", "234.234.234-67")
    }

}