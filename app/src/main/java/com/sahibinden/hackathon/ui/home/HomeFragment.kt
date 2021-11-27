package com.sahibinden.hackathon.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.sahibinden.hackathon.util.HelpType
import com.sahibinden.hackathon.R

import com.sahibinden.hackathon.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.navController = view.findNavController()

        binding.ivNeedHelp.setOnClickListener {
            goHelpFragment(HelpType.NEEDER)
        }
        binding.ivWantToHelp.setOnClickListener {
            goHelpFragment(HelpType.VOLUNTARILY)
        }
    }

    private fun goHelpFragment(help_type: HelpType){
        //if (this::navController.isInitialized)
            //navController.navigate(HelpFragment)
        //val action = HomeFragmentDirections.actionHomeFragmentToHelpFragment(help_type)
        navController.navigate(HomeFragmentDirections.actionHomeFragmentToHelpFragment(help_type))
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}