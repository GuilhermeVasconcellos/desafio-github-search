package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var repoItemListener: (Repository) -> Unit = {}
    var btnShareListener: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Realizar o bind do viewHolder

        holder.repoName.text = repositories[position].name

        // Exemplo de click no item
        //holder.itemView.setOnClickListener {
        // carItemLister(repositores[position])
        //}
        holder.repoName.setOnClickListener {
            repoItemListener(repositories[position])
        }

        holder.shareIcon.setOnClickListener {
            btnShareListener(repositories[position])
        }
    }

    // Pega a quantidade de repositorios da lista para
    // realizar a contagem da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //Implementar o ViewHolder para os repositorios

        var repoName: TextView
        var shareIcon: ImageView

        init {
            view.apply {
                repoName = findViewById(R.id.tv_repo_name)
                shareIcon = findViewById(R.id.iv_share)
            }
        }
    }
}


