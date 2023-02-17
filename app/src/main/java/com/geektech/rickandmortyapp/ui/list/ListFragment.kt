package com.geektech.rickandmortyapp.ui.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.geektech.rickandmortyapp.R
import com.geektech.rickandmortyapp.ui.SharedViewModelFactory
import com.geektech.rickandmortyapp.api.Repository
import com.geektech.rickandmortyapp.ui.SharedViewModel


class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels {
        SharedViewModelFactory(
            Repository()
        )
    }
    private var adapter=CharacterAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModel.getCharacters(1)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rView.layoutManager=StaggeredGridLayoutManager(2, StaggeredGridLayoutManager,VERTICAL)

        sharedViewModel.listCharacters.observe(viewLifecycleOwner,{response->
            if (response.isSuccessful){
                adapter.setCharacters(response.body()!!.result)
            }
                Log.d("Result", response.body())!!.results.toString())
            }else {
                Log.d("ResultError", response.code().toString())
            }
        })

        binding.apply{
        rView.layoutManager=StaggeredGridLayoutManager(2, StaggeredGridLayoutManager,VERTICAL)
        rView.adapter=adapter
        binding.btnFilter.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_filterFragment)
        }
        binding.TvTitleCharacters.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_filterFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




