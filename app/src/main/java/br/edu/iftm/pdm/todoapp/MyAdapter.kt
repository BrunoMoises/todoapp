package br.edu.iftm.pdm.todoapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    lateinit var mContext: Context
    lateinit var mString: Array<String>
    lateinit var mBackground: Array<Int>

    fun MyAdapter(context: Context, strTasks: String, intBackground: Int) {
        mContext = context
        mString = arrayOf(strTasks)
        mBackground = arrayOf(intBackground)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTextTask: TextView = itemView.findViewById(R.id.txtTask)
        var mTextBackground: TextView = itemView.findViewById(R.id.txtBackground)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater: LayoutInflater = LayoutInflater.from(mContext)
        var view: View = inflater.inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mTextTask.text = mString[position]
        var backgroundVal: Int = mBackground[position]
        holder.mTextBackground.setBackgroundColor(backgroundVal)
    }

    override fun getItemCount(): Int {
        return mString.size
    }

}