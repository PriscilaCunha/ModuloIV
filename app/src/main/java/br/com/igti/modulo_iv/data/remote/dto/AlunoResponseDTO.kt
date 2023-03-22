package br.com.igti.modulo_iv.data.remote.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.time.LocalDate

data class AlunoResponseDTO (
    @SerializedName("id")
    private val id : String,
    @SerializedName("nome")
    private val nome : String,
    @SerializedName("sobrenome")
    private val sobrenome : String,
    @SerializedName("nascimento")
    private val nascimento : LocalDate
) : Serializable