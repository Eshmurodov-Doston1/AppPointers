package com.example.apppointers.adapters.student

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apppointers.databinding.ItemStudentBinding
import com.example.apppointers.models.Student
import com.squareup.picasso.Picasso

class AdapterStudents(var onItemClickLisftener: OnItemClickLisftener):ListAdapter<Student,AdapterStudents.Vh>(MyDiffUtill()) {
    inner class Vh(var itemStudentBinding: ItemStudentBinding):RecyclerView.ViewHolder(itemStudentBinding.root){
        fun onBind(student: Student,position: Int){
            Picasso.get().load(student.image).into(itemStudentBinding.imageStudent)
            itemStudentBinding.name.text = "${student.firstName} ${student.lastName}"
            itemStudentBinding.percent.text = "Hali Mavjud emas"
            itemView.setOnClickListener {
                onItemClickLisftener.onIrtemClick(student,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemStudentBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position),position)
    }

    class MyDiffUtill:DiffUtil.ItemCallback<Student>(){
        override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem.equals(newItem)
        }
    }
    interface OnItemClickLisftener{
        fun onIrtemClick(student: Student,position: Int)
    }
}