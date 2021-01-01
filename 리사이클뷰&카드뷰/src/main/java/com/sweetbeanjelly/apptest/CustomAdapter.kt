package com.sweetbeanjelly.apptest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomAdapter constructor(context : Context, items : List<Memo>) : RecyclerView.Adapter<CustomViewHolder>() {

    private var context : Context
    private var items : List<Memo>

    init {
        this.context = context
        this.items = items
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item : Memo = items.get(position)

        holder.title.setText(item.title)
        holder.content.setText(item.content)
        holder.time.setText(item.time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        var customViewHolder = CustomViewHolder(view)
        return customViewHolder
    }

    override fun getItemCount(): Int = this.items.size
}

class CustomViewHolder constructor(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var title = itemView.findViewById<TextView>(R.id.item_title)
    var content = itemView.findViewById<TextView>(R.id.item_content)
    var time = itemView.findViewById<TextView>(R.id.item_time)
}

