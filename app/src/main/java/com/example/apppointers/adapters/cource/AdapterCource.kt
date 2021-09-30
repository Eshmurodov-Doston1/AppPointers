package com.example.apppointers.adapters.cource

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apppointers.databinding.ItemLessonBinding
import com.example.apppointers.models.Lesson

class AdapterCource(var onItemClickListener:OnItemClickListener):ListAdapter<Lesson,AdapterCource.Vh>(MyDiffUtill()) {
    inner class Vh(var itemLessonBinding: ItemLessonBinding):RecyclerView.ViewHolder(itemLessonBinding.root){
        fun onBind(lesson: Lesson,position: Int){
            itemLessonBinding.date.text = lesson.date
            itemLessonBinding.name.text = lesson.name
            itemView.setOnClickListener {
                onItemClickListener.OnItemClick(lesson,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemLessonBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position),position)
    }
    class MyDiffUtill:DiffUtil.ItemCallback<Lesson>(){
        override fun areItemsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
            return oldItem.equals(newItem)
        }
    }
    interface OnItemClickListener{
        fun OnItemClick(lesson: Lesson,position: Int)
    }
}