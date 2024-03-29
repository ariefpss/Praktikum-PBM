package com.example.praktikumpbm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TbWordListAdapter internal constructor(context: Context) : RecyclerView.Adapter<TbWordListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var tbwords = emptyList<TbWord>()

    inner class WordViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView =itemView.findViewById(R.id.itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recycler_view_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder,
                                  position: Int) {
        val current = tbwords[position]
        holder.wordItemView.text = current.tbword
    }

    internal fun setWords(tbwords: List<TbWord>) {
        this.tbwords = tbwords
        notifyDataSetChanged()
    }

    override fun getItemCount() = tbwords.size
}