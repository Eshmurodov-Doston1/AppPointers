package com.example.apppointers.ui.home

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.apppointers.R
import com.example.apppointers.adapters.group.GroupAdapter
import com.example.apppointers.databinding.FragmentHomeBinding
import com.example.apppointers.models.Group
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
     private val binding by viewBinding(FragmentHomeBinding::bind)
    lateinit var groupAdapter: GroupAdapter
    lateinit var listGroup:ArrayList<Group>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loadGroup()
            groupAdapter = GroupAdapter(object: GroupAdapter.OnItemClickListener{
                override fun onItemClick(group: Group, position: Int) {
                    var bundle = Bundle()
                    var navoptions= NavOptions.Builder()
                    navoptions.setEnterAnim(R.anim.enter)
                    navoptions.setExitAnim(R.anim.exit)
                    navoptions.setPopEnterAnim(R.anim.pop_enter)
                    navoptions.setPopExitAnim(R.anim.pop_exit)
                    findNavController().navigate(R.id.studentsFragment,bundle,navoptions.build())
                }
            })
            groupAdapter.submitList(listGroup)
            rvGroup.adapter = groupAdapter
            var calback = object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    (activity as AppCompatActivity).finish()
                }
            }
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, calback)

        }
    }

    private fun loadGroup() {
        listGroup = ArrayList()
        listGroup.add(Group("Android G20","Sanjar Suvonov","16:30",20,"Toq"))
        listGroup.add(Group("Android G21","Sanjar Suvonov","19:00",20,"Juft"))
        listGroup.add(Group("Android G22","Sanjar Suvonov","09:00",20,"Juft"))
        listGroup.add(Group("Android G23","Sanjar Suvonov","11:00",20,"Toq"))
        listGroup.add(Group("Android G24","Sanjar Suvonov","14:00",20,"Juft"))
        listGroup.add(Group("Android G25","Sanjar Suvonov","16:30",20,"Juft"))
        listGroup.add(Group("Android G26","Sanjar Suvonov","16:30",20,"Toq"))
        listGroup.add(Group("Android G27","Sanjar Suvonov","16:30",20,"Juft"))
    }
}