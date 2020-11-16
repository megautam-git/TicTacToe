package com.example.tictactoe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tictactoe.databinding.RowBinding

class GameAdapter( var gamelist:List<Game>,
                   private val listener: RecyclerViewClickListener): RecyclerView.Adapter<GameAdapter.MyViewHolder>() {
    override fun getItemCount() = gamelist.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.rowBinding.mygame = gamelist[position]
        holder.itemView.setOnClickListener {
            listener.onRecyclerViewItemClick(it,gamelist[position])
        }/*
        holder.recyclerviewMovieBinding.layoutLike.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.layoutLike, movies[position])
        }*/
    }


    inner class MyViewHolder(
        val rowBinding: RowBinding
    ) : RecyclerView.ViewHolder(rowBinding.root)
}

