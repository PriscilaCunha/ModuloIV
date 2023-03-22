package br.com.igti.modulo_iv.ui.alunos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igti.modulo_iv.R
import br.com.igti.modulo_iv.data.remote.dto.AlunoResponseDTO

// O adapter (função customizada que vai montar o layout) funciona com os 3 métodos:
// onCreateViewHolder() - Vai criar o layout
// onBindViewHolder() - vai setar as informações
// getItemCount() - vai falar para o RecyclerView/Aplicativo quantos itens há na lista para ele criar o layout essa quantidade de vezes

class AlunoAdapter(private val dataSet: List<AlunoResponseDTO>) :
    RecyclerView.Adapter<AlunoAdapter.ViewHolder>() {

    // Fornece uma referência ao tipo de view sendo usado (custom ViewHolder).
    // Esta classe vai criar o layout de cada item
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNome: TextView
        val txtSobrenome: TextView

        init {
            // Define click listener for the ViewHolder's View.
            txtNome = view.findViewById(R.id.txtNome)
            txtSobrenome = view.findViewById(R.id.txtSobrenome)
        }
    }

    // Cria novas views (chamada pelo layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        ViewHolder (
            // Cria uma nova view, que define a UI do item da lista
            LayoutInflater
                .from(viewGroup.context)
                .inflate(R.layout.aluno_item_row, viewGroup, false)
        )

    // Substitui o conteúdo da view (chamada pelo layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Obtém o elemento do seu dataset na position e substitui o conteúdo da view com este elemento
        viewHolder.txtNome.text = dataSet[position].nome
        viewHolder.txtSobrenome.text = dataSet[position].sobrenome
    }

    // Retorna o tamanho do seu dataset (chamada pelo layout manager)
    override fun getItemCount() = dataSet.size

}

