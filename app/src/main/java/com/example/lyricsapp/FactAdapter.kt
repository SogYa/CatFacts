package com.example.lyricsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lyricsapp.repository.model.Fact

class FactAdapter(private val arrayList: List<Fact>) :
    RecyclerView.Adapter<FactAdapter.FactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fact_item, parent, false)
        return FactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        holder.mTitleView.text = arrayList[position].text
        holder.mDateView.text = arrayList[position].updateAt
    }

    override fun getItemCount(): Int = arrayList.size

    class FactViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val mTitleView: TextView = itemView.findViewById(R.id.textView)
        val mDateView: TextView = itemView.findViewById(R.id.dateView)

    }
}

