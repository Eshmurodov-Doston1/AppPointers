package com.example.apppointers.adapters.group

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apppointers.databinding.ItemGroupBinding
import com.example.apppointers.models.Group

class GroupAdapter(var onItemClickListener: OnItemClickListener):ListAdapter<Group, GroupAdapter.Vh>(
    MyDiffUtill()
) {
    inner class Vh(var itemGroupBinding: ItemGroupBinding):RecyclerView.ViewHolder(itemGroupBinding.root){
        fun onBind(group: Group,position: Int){
            itemGroupBinding.apply {
                countStudent.text = "Talabalar soni ${group.studentCount} ta"
                nameGroup.text  =group.name
                time.text = group.time
                day.text = group.day
                itemView.setOnClickListener {
                    onItemClickListener.onItemClick(group,position)
                }
            }
        }
    }


    class MyDiffUtill:DiffUtil.ItemCallback<Group>(){
        override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean {
            return oldItem.equals(newItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemGroupBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position),position)
    }
    interface OnItemClickListener{
        fun onItemClick(group: Group,position: Int)
    }
}