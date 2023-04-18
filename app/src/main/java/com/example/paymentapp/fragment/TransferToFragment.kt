package com.example.paymentapp.fragment

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.paymentapp.PaymentViewModel
import com.example.paymentapp.R
import com.example.paymentapp.databinding.TransferToFragmentBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TransferToFragment : Fragment() {

    private var _binding: TransferToFragmentBinding? = null
    private val sharedViewModel: PaymentViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TransferToFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.transferNextButton.setOnClickListener {
            sharedViewModel.setName(binding.editTextTransferTo.text.toString())
            if(sharedViewModel.getName() == " " || sharedViewModel.getName() == "" ) {
                binding.editTextTransferTo.error = "Enter a valid name"

            }
            else {
                findNavController().navigate(R.id.action_TransferToFragment_to_PayAmountFragment)
            }
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_TransferToFragment_to_HomeScreenFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}