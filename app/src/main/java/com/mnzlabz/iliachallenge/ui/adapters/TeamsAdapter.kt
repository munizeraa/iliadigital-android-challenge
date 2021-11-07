package com.mnzlabz.iliachallenge.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mnzlabz.iliachallenge.R
import com.mnzlabz.iliachallenge.data.model.Team
import com.mnzlabz.iliachallenge.databinding.TeamListItemBinding

class TeamsAdapter(): RecyclerView.Adapter<TeamViewHolder>() {

    private val teams = ArrayList<Team>()

    fun setItems(items: ArrayList<Team>) {
        this.teams.clear()
        this.teams.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TeamListItemBinding.inflate(inflater, parent, false)

        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teams[position])
    }

    override fun getItemCount(): Int = teams.size

}

class TeamViewHolder(private val binding: TeamListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Team) {
        binding.name.text = item.name
        binding.description.text = item.description
        binding.conference.text = item.conference

        Glide.with(binding.root.context)
            .load(item.teamImageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.avatar)
    }
}

