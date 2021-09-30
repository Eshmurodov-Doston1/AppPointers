package com.example.apppointers.ui.group

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.apppointers.R
import com.example.apppointers.adapters.student.AdapterStudents
import com.example.apppointers.databinding.FragmentStudentsBinding
import com.example.apppointers.models.Student
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StudentsFragment : Fragment(R.layout.fragment_students) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val binding by viewBinding(FragmentStudentsBinding::bind)
    lateinit var adapterStudents: AdapterStudents
    lateinit var listStudents:ArrayList<Student>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loadStudent()
            adapterStudents = AdapterStudents(object:AdapterStudents.OnItemClickLisftener{
                override fun onIrtemClick(student: Student, position: Int) {
                    var bundle = Bundle()
                    bundle.putSerializable("student",student)
                    var navOptions = NavOptions.Builder()
                    navOptions.setEnterAnim(R.anim.enter)
                    navOptions.setExitAnim(R.anim.exit)
                    navOptions.setPopEnterAnim(R.anim.pop_enter)
                    navOptions.setPopExitAnim(R.anim.pop_exit)
                    findNavController().navigate(R.id.studentFragment,bundle,navOptions.build())
                }
            })
            adapterStudents.submitList(listStudents)
            rvStudents.adapter = adapterStudents
        }
    }

    private fun loadStudent() {
        listStudents = ArrayList()
        listStudents.add(Student("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3Wjd-Cak78mooEfHTx64D7xhFtgBMZRFiiQ&usqp=CAU","Dostonbek","Eshmurodov","Android G18"))
        listStudents.add(Student("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoAEssp5xBCP420VJTAkFru3VTpDnHVnXzjg&usqp=CAU","Dostonbek","Eshmurodov","Android G18"))
        listStudents.add(Student("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoAEssp5xBCP420VJTAkFru3VTpDnHVnXzjg&usqp=CAU","Dostonbek","Eshmurodov","Android G18"))
        listStudents.add(Student("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoAEssp5xBCP420VJTAkFru3VTpDnHVnXzjg&usqp=CAU","Dostonbek","Eshmurodov","Android G18"))
        listStudents.add(Student("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoAEssp5xBCP420VJTAkFru3VTpDnHVnXzjg&usqp=CAU","Dostonbek","Eshmurodov","Android G18"))
        listStudents.add(Student("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoAEssp5xBCP420VJTAkFru3VTpDnHVnXzjg&usqp=CAU","Dostonbek","Eshmurodov","Android G18"))
        listStudents.add(Student("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoAEssp5xBCP420VJTAkFru3VTpDnHVnXzjg&usqp=CAU","Dostonbek","Eshmurodov","Android G18"))
        listStudents.add(Student("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoAEssp5xBCP420VJTAkFru3VTpDnHVnXzjg&usqp=CAU","Dostonbek","Eshmurodov","Android G18"))
        listStudents.add(Student("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoAEssp5xBCP420VJTAkFru3VTpDnHVnXzjg&usqp=CAU","Dostonbek","Eshmurodov","Android G18"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StudentsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StudentsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}