package com.example.swipeeffectdemo

import android.content.ClipData
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.squareup.picasso.Picasso

class CardListAdapter(val context: Context, val list: ArrayList<Item>): RecyclerView.Adapter<CardListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.name.text = item.name
        holder.description.text = item.description
        holder.price.text = item.price
        Picasso.get().load(item.thumbnail).into(holder.thumbnail)
    }

    fun removeItem(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun restoreItem(item: Item, position: Int) {
        list.add(position, item)
        notifyItemInserted(position)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.name)
        var description = itemView.findViewById<TextView>(R.id.description)
        var price = itemView.findViewById<TextView>(R.id.description)
        var thumbnail = itemView.findViewById<ImageView>(R.id.thumbnail)
        var viewBackground = itemView.findViewById<RelativeLayout>(R.id.view_background)
        var viewForeground = itemView.findViewById<RelativeLayout>(R.id.view_foreground)
    }
}
