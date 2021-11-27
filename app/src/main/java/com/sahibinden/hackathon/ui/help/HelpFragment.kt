package com.sahibinden.hackathon.ui.help

import android.animation.AnimatorInflater
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.sahibinden.hackathon.mock.Adress
import com.sahibinden.hackathon.mock.City
import com.sahibinden.hackathon.HelpApplication
import com.sahibinden.hackathon.R
import com.sahibinden.hackathon.data.model.DemandModel
import com.sahibinden.hackathon.databinding.FragmentHelpBinding
import com.sahibinden.hackathon.util.CustomAnimationListener
import com.sahibinden.hackathon.vm.HelpViewModel
import com.sahibinden.hackathon.vm.ViewModelFactory


class HelpFragment : Fragment() {

    private var _binding: FragmentHelpBinding? = null
    private val binding get() = _binding!!

    private val adressList: List<City> = Adress().getAdressList()
    private val args: HelpFragmentArgs by navArgs()


    private val helpViewModel: HelpViewModel by viewModels {
        ViewModelFactory((this.requireActivity().application) as HelpApplication)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // val leftToCenter: Animation = anim

        initRequirementTypesMenu()
        initCitiesWithListener()
        initBtnDemandListener()
        initSingleEventListener()
    }

    private fun initSingleEventListener() {
        helpViewModel.responseState.observe(viewLifecycleOwner, Observer {
            initShowDialogAnimation(it)
        })
    }

    private fun initRequirementTypesMenu(){
        val requirements = resources.getStringArray(R.array.requirements)
        val adapter = ArrayAdapter(requireContext(), R.layout.basic_list_item, requirements)
        binding.tvRequirment.setAdapter(adapter)
    }

    private fun initCitiesWithListener(){
        binding.tvCity.setAdapter(
            getCommonAdapter(adressList)
        )
        binding.tvCity.setOnItemClickListener { _, _, cityPosition, _ ->
            initDistrictsWithListener(cityPosition)
            binding.tvDistrict.isEnabled = true
        }
    }

    private fun initDistrictsWithListener(selectedCityPosition:Int){
        binding.tvDistrict.setAdapter(
            getCommonAdapter(adressList[selectedCityPosition].districts)
        )
        binding.tvDistrict.setOnItemClickListener { _, _, districtPosition, _ ->
            binding.tvNeighbourhood.isEnabled = true
            initNeighbourhoodsWithListener(selectedCityPosition,districtPosition)
        }
    }

    private fun initNeighbourhoodsWithListener(selectedCityPosition:Int,selectedDistrictPosition:Int){
        binding.tvNeighbourhood.setAdapter(
            getCommonAdapter(adressList[selectedCityPosition].districts[selectedDistrictPosition].neighbourhoods)
        )
    }

    private fun initBtnDemandListener() {

        val demandType = args.helpType

        binding.btnMakeDemand.setOnClickListener {

            val demand = DemandModel(
                binding.etNameSurname.text.toString(),
                binding.etPhoneNumber.text.toString(),
                binding.etTcNo.text.toString(),
                binding.tvRequirment.text.toString(),
                binding.tvQuantity.text.toString(),
                binding.tvCity.text.toString(),
                binding.tvDistrict.text.toString(),
                binding.tvNeighbourhood.text.toString(),
                binding.tvNote.text.toString(),
                demandType.toString())

            sendRequest(demand)

        }
    }

    private fun sendRequest(demandModel: DemandModel) =
        helpViewModel.sendDemand(demandModel)


    private fun <T: Any> getCommonAdapter(data:List<T>) =
        ArrayAdapter(requireContext(), R.layout.basic_list_item, data)

    private fun initShowDialogAnimation(isSuccess:Boolean) {

        val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.response_dialog_anim_show)
        anim.setAnimationListener(object : CustomAnimationListener(){
            override fun onAnimationEnd(animation: Animation?) {
                hideDialogAnimation()
            }
        })
        binding.dialogItem.apply {
            if (!isSuccess){
                background = ContextCompat.getDrawable(context,R.drawable.ic_need_help)
            }

            visibility = View.VISIBLE
            startAnimation(anim)
        }
        //binding.dialogItem.visibility = View.VISIBLE
        //binding.dialogItem.startAnimation(anim)
    }

    private fun hideDialogAnimation() {
        binding.dialogItem.startAnimation(
            AnimationUtils.loadAnimation(requireContext(), R.anim.response_dialog_anim_hide)
        ).apply { binding.dialogItem.visibility = View.INVISIBLE }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}






