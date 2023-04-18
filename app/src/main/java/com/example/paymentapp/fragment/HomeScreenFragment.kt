package com.example.paymentapp.fragment

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.paymentapp.R
import com.example.paymentapp.databinding.HomeScreenFragmentBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeScreenFragment : Fragment() {

    private var _binding: HomeScreenFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.transferButton.setOnClickListener {
            findNavController().navigate(R.id.action_HomeScreenFragment_to_TransferToFragment)
        }
        binding.viewBalanceButton.setOnClickListener {
            findNavController().navigate(R.id.action_HomeScreenFragment_to_currentBalanceFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}