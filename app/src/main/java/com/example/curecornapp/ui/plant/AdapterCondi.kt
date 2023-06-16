package com.example.curecornapp.ui.plant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.curecornapp.R

private val String.jsonMemberClass: Any
    get() {
        return true
    }

class AdapterCondi(val dataCondi: String)
    : RecyclerView.Adapter<AdapterCondi.ListViewHolder>() {

    class ListViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvCondi = view.findViewById<TextView>(R.id.tv_condition_fill)
        val tvConfi = view.findViewById<TextView>(R.id.tv_confidence_fill)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_condition, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(dataCondi != null) {
            return dataCondi.hashCode()
        }
        return 0
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.apply {
            tvCondi.text = dataCondi?.get(position).toString()
            tvConfi.text = dataCondi?.get(position)?.toString()

            itemView.setOnClickListener {
                val condi = dataCondi.jsonMemberClass
                Toast.makeText(holder.itemView.context, "${condi}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}