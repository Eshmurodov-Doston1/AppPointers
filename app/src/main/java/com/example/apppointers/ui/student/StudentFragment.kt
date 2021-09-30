package com.example.apppointers.ui.student

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.apppointers.R
import com.example.apppointers.adapters.cource.AdapterCource
import com.example.apppointers.databinding.DailogCourceBinding
import com.example.apppointers.databinding.FragmentStudentBinding
import com.example.apppointers.databinding.FragmentStudentsBinding
import com.example.apppointers.models.Lesson
import com.example.apppointers.models.Student
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StudentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentFragment : Fragment(R.layout.fragment_student) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private val binding by viewBinding(FragmentStudentBinding::bind)
    lateinit var adapterCource: AdapterCource
    lateinit var listCourse:ArrayList<Lesson>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loadCource()
            val student = arguments?.getSerializable("student") as Student
            (activity as AppCompatActivity).supportActionBar?.title = "${student.firstName} ${student.lastName}"
            adapterCource = AdapterCource(object:AdapterCource.OnItemClickListener{
                override fun OnItemClick(lesson: Lesson, position: Int) {
                 var alertDialog = AlertDialog.Builder(requireContext(),R.style.BottomSheetDialogThem)
                    val create = alertDialog.create()
                    var dialogCource = DailogCourceBinding.inflate(LayoutInflater.from(requireContext()),null,false)
                    dialogCource.apply {

                    }
                    create.setView(dialogCource.root)
                    create.show()
                }
            })
            adapterCource.submitList(listCourse)
            rv.adapter = adapterCource

        }
    }

    private fun loadCource() {
        listCourse = ArrayList()
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
        listCourse.add(Lesson("Kotlinga kirish",true,"xdsckadjxhzh","12.12.2021"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StudentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StudentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}