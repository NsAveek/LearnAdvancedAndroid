package aveek.com.learnadvancedandroid.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.row_home.view.*

class ListViewHolder (view : View) : RecyclerView.ViewHolder(view){
    fun bind(item : String){
        itemView.tvTest.setText(item)
    }
}