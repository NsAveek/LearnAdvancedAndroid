package aveek.com.learnadvancedandroid.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import aveek.com.learnadvancedandroid.R

class ListAdapter(var context : Context, var itemList: List<String>) : RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListViewHolder {
        return ListViewHolder(View.inflate(context, R.layout.row_home, null))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder?, position: Int) {
        holder?.bind(itemList.get(position))
    }
}