package com.geektech.rickandmortyapp.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.geektech.rickandmortyapp.R
import com.geektech.rickandmortyapp.api.Repository
import com.geektech.rickandmortyapp.databinding.FragmentFilterBinding
import com.geektech.rickandmortyapp.ui.SharedViewModel
import com.geektech.rickandmortyapp.ui.SharedViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FilterFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentFilterBinding? = null
    private val binding get() = _binding!!
    private  val sharedViewModel:SharedViewModel by activityViewModels(SharedViewModelFactory(
        Repository()
    ))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            sharedViewModel.filterValue.observe(viewLifecycleOwner,{item->

                    chipGroupStatus.setChipChecked(item[0])
                    radioGroupGender.setButtonChecked(item[1])
            })


            binding.btnApplyFilter.setOnClickListener{
                if(chipGroupStatus.getTextChipChecked().isNotEmpty() &&
                    radioGroupGender.getTextButtonChecked().isNotEmpty()) {
                    sharedViewModel.getByStatusAndGender(
                        chipGroupStatus.getTextChipChecked(),
                        radioGroupGender.getTextButtonChecked(), 1
                    )
                }else{
                    if(chipGroupStatus.getTextChipChecked().isNotEmpty()) {
                        sharedViewModel.getByStatus(
                            chipGroupStatus.getTextChipChecked(),1
                        )
                    }else {
                        sharedViewModel.getByGender(
                            radioGroupGender.getTextButtonChecked(),1
                        )
                    }

                   sharedViewModel.filterValue.value= arrayOf(chipGroupStatus.checkedChipId,
                            radioGender,checkedRadioButtonId)
                        findNavController().popBackStack(R.id.filterFragment,false)
                    }
                }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}