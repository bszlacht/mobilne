package com.example.bartoszszlachtaandroidlab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bartoszszlachtaandroidlab1.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnNav2.setOnClickListener{
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            }
            btnNav3.setOnClickListener{
                findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
            }
            btnNavActions.setOnClickListener{
                findNavController().navigate(R.id.action_firstFragment_to_actionsActivity)
            }
        }
    }
}