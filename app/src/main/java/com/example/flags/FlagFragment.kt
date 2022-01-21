package com.example.flags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.flags.databinding.FragmentFlagBinding

class FlagFragment : Fragment() {

    private val flagViewModel: FlagViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFlagBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.flagViewModel = flagViewModel
        binding.recyclerView.adapter = FlagGridAdapter()
        return binding.root

    }

}